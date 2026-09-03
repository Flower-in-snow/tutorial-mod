package com.example.tutorialmod.item.custom;

import com.example.tutorialmod.sound.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPart;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.List;

public class Hyperion extends SwordItem {
    private static final int RANGE = 10;
    private static final int COOL_DOWN = 2;
    private static final int AOE_RADIUS = 6;
    private static final int ATTACK_DAMAGE = 20;
    private static final int EFFECT_TIME = 100;
    private static final int ABSORPTION_EFFECT_LEVEL = 2;
    private static final int RESISTANCE_EFFECT_LEVEL = 0;

    public Hyperion(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof LivingEntity livingEntity){
            //selected表示这把剑正在主手被握着；同时检查副手
            if (selected || livingEntity.getOffHandStack() == stack){
                livingEntity.fallDistance = 0.0F;
            }
        }
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient()){

            Vec3d oldpos = user.getPos();
            Vec3d direction = user.getRotationVector();
            Vec3d startpoint = user.getEyePos();
            Vec3d endpoint = startpoint.add(direction.multiply(RANGE));

            BlockHitResult blockHitResult = world.raycast(new RaycastContext(startpoint, endpoint, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, user));
            Vec3d destpoint = endpoint;
            if (blockHitResult.getType() != HitResult.Type.MISS){
                destpoint = blockHitResult.getPos().subtract(direction.multiply(0.5));
            }

            user.requestTeleport(destpoint.x, destpoint.y, destpoint.z);

            world.playSound(null, oldpos.getX(), oldpos.getY(), oldpos.getZ(), ModSoundEvents.TELEPORT, SoundCategory.PLAYERS, 1.0F, 1.0F);
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSoundEvents.EXPLODE, SoundCategory.PLAYERS, 1.0F, 1.0F);

            Box aoeBox = new Box(destpoint, destpoint).expand(AOE_RADIUS);
            for (Entity entity : user.getWorld().getOtherEntities(user, aoeBox, entity -> (entity instanceof LivingEntity || entity instanceof EnderDragonPart) && !entity.isSpectator())){
                entity.damage(world.getDamageSources().playerAttack(user), ATTACK_DAMAGE);
            }

            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, EFFECT_TIME, ABSORPTION_EFFECT_LEVEL, false, false, false));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, EFFECT_TIME, RESISTANCE_EFFECT_LEVEL, false, false, false));

            if (world instanceof ServerWorld serverWorld){//在服务器端渲染粒子效果，需要获取目标离我们的距离
                double length = startpoint.distanceTo(destpoint);
                for (double d = 0; d <= length; d += 0.5){
                    Vec3d pos = startpoint.add(direction.multiply(d));
                    serverWorld.spawnParticles(ParticleTypes.PORTAL, pos.x, pos.y, pos.z, 1, 0, 0, 0, 1.0F);
                }
                serverWorld.spawnParticles(ParticleTypes.EXPLOSION, destpoint.x, destpoint.y, destpoint.z, 2, 0, 0, 0, 1.0F);
                serverWorld.spawnParticles(ParticleTypes.ASH, destpoint.x, destpoint.y, destpoint.z, 4, AOE_RADIUS, 0, AOE_RADIUS, 1.0F);
            }
        }
        user.getItemCooldownManager().set(itemStack.getItem(), COOL_DOWN);
        return TypedActionResult.success(itemStack, false);
    }

    public static final String Hyperion_Tooltip_Line1 = "tooltip.tutorialmod.hyperion.line1";
    public static final String Hyperion_Tooltip_Line2 = "tooltip.tutorialmod.hyperion.line2";
    public static final String Hyperion_Tooltip_Line3 = "tooltip.tutorialmod.hyperion.line3";
    public static final String Hyperion_Tooltip_Line4 = "tooltip.tutorialmod.hyperion.line4";
    public static final String Hyperion_Tooltip_Line5 = "tooltip.tutorialmod.hyperion.line5";
    public static final String Hyperion_Tooltip_Line6 = "tooltip.tutorialmod.hyperion.line6";
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(Prospector.SPACE));
        tooltip.add(Text.translatable(Hyperion_Tooltip_Line1));
        tooltip.add(Text.translatable(Hyperion_Tooltip_Line2, Text.literal(String.valueOf(RANGE)).formatted(Formatting.GREEN)));
        tooltip.add(Text.translatable(Hyperion_Tooltip_Line3, Text.literal(String.valueOf(ATTACK_DAMAGE)).formatted(Formatting.RED)));
        tooltip.add(Text.translatable(Hyperion_Tooltip_Line4, Text.literal(String.valueOf(AOE_RADIUS)).formatted(Formatting.GREEN)));
        tooltip.add(Text.translatable(Hyperion_Tooltip_Line5));
        tooltip.add(Text.translatable(Hyperion_Tooltip_Line6, Text.literal(String.valueOf(EFFECT_TIME/20)).formatted(Formatting.YELLOW)));
        super.appendTooltip(stack, context, tooltip, type);
    }
}
