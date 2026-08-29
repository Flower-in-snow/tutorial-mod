package com.example.tutorialmod.item.custom;

import com.example.tutorialmod.effect.ModStatusEffects;
import com.example.tutorialmod.sound.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class IceSprayWand extends Item {
    private static final double RANGE = 20.0D;
    private static final int COOLDOWN = 2;
    private static final int ATTACK_DAMAGE = 8;
    private static final double FROZEN_CHANCE = 0.5;
    private static final int FROZEN_TIME = 20;

    private record TargetHit(LivingEntity target, Vec3d hitPoint){}//新建一个record类型，可以让方法返回一个类型，取值直接取形参的值

    public IceSprayWand(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (!world.isClient){
            world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSoundEvents.ICE_SPRAY, SoundCategory.PLAYERS, 1.0F, 1.0F);

            Vec3d startpoint = user.getEyePos();
            Vec3d direction = user.getRotationVector();
            Vec3d endpoint = startpoint.add(direction.multiply(RANGE));

            //blockHitResult是射线检测结果，判断射线是否和碰撞箱有交点
            BlockHitResult blockHitResult = world.raycast(new RaycastContext(startpoint, endpoint, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, user));
            if (blockHitResult.getType() != HitResult.Type.MISS){//击中了物体碰撞箱，但是我们不知道这个物体离我们有多远
                endpoint = blockHitResult.getPos();
            }

            TargetHit targetHit = findTarget(user,startpoint,endpoint);//这个方法判断这个方向上我们击中离我们最近的实体是哪个

            if (targetHit != null){
                endpoint = targetHit.hitPoint();//如果击中最近的实体，把向量终点改成击中的这个点，方便后续渲染
                targetHit.target().damage(world.getDamageSources().playerAttack(user), ATTACK_DAMAGE);
                //接下来是随机数判断施加冰冻效果
                if (world.random.nextFloat() < FROZEN_CHANCE){
                    targetHit.target().addStatusEffect(new StatusEffectInstance(ModStatusEffects.FROZEN, FROZEN_TIME, 0, false, false, false));
                }
            }

            if (world instanceof ServerWorld serverWorld){//在服务器端渲染粒子效果，需要获取目标离我们的距离
                double length = startpoint.distanceTo(endpoint);
                for (double d = 0; d <= length; d += 0.5){
                    Vec3d pos = startpoint.add(direction.multiply(d));
                    serverWorld.spawnParticles(ParticleTypes.SNOWFLAKE, pos.x, pos.y, pos.z, 1, 0, 0, 0, 1.0F);
                }
            }

        }
        user.getItemCooldownManager().set(stack.getItem(), COOLDOWN);
        return  TypedActionResult.success(stack, false);
    }

    private static @Nullable TargetHit findTarget(PlayerEntity user, Vec3d startpoint, Vec3d endpoint) {
        TargetHit nearest = null;
        double nearestDistance = startpoint.distanceTo(endpoint);
        // expand(1.0)：放宽盒子的预筛选范围，只靠下面的碰撞箱raycast做精确判断
        for (Entity entity : user.getWorld().getOtherEntities(user, new Box(startpoint, endpoint).expand(1.0), entity -> entity instanceof LivingEntity && !entity.isSpectator() && entity.canHit())) {
            Optional<Vec3d> hit = entity.getBoundingBox().raycast(startpoint, endpoint);
            if (hit.isPresent()) {//射线真的穿过了这个实体的碰撞箱
                double distance = startpoint.distanceTo(hit.get());
                if (distance < nearestDistance) {
                    nearest = new TargetHit((LivingEntity) entity, hit.get());
                    nearestDistance = distance;
                }
            }
        }
        return nearest;
    }

    public static final String Ice_Spray_Wand_Tooltip_Line1 = "tooltip.tutorialmod.ice_spray_wand_line1";
    public static final String Ice_Spray_Wand_Tooltip_Line2 = "tooltip.tutorialmod.ice_spray_wand_line2";
    public static final String Ice_Spray_Wand_Tooltip_Line3 = "tooltip.tutorialmod.ice_spray_wand_line3";
    public static final String Ice_Spray_Wand_Tooltip_Line4 = "tooltip.tutorialmod.ice_spray_wand_line4";
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        super.appendTooltip(stack, context, tooltip, type);
        tooltip.add(Text.translatable(Prospector.SPACE));
        tooltip.add(Text.translatable(Ice_Spray_Wand_Tooltip_Line1));
        tooltip.add(Text.translatable(Ice_Spray_Wand_Tooltip_Line2));
        tooltip.add(Text.translatable(Ice_Spray_Wand_Tooltip_Line3, Text.literal(String.valueOf(ATTACK_DAMAGE)).formatted(Formatting.RED)));
        tooltip.add(Text.translatable(Ice_Spray_Wand_Tooltip_Line4, Text.literal(String.valueOf(FROZEN_TIME / 20)).formatted(Formatting.RED)));
    }
}
