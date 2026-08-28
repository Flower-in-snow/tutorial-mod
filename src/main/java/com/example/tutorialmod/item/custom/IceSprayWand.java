package com.example.tutorialmod.item.custom;

import com.example.tutorialmod.sound.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class IceSprayWand extends Item {
    private static final double RANGE = 20.0D;
    private static final int COOLDOWN = 20;
    private static final int ATTACKDAMAGE = 8;


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

            Entity Target = findTarget(user,startpoint,endpoint);//这个方法判断这个方向上我们击中离我们最近的实体是哪个

            if (Target != null){
                Optional<Vec3d> hit = Target.getBoundingBox().raycast(startpoint, endpoint);
                if (hit.isPresent()){
                    endpoint = hit.get();//如果击中最近的实体，把向量终点改成击中的这个点，方便后续渲染
                }
                Target.damage(world.getDamageSources().playerAttack(user), ATTACKDAMAGE);
            }

            if (world instanceof ServerWorld serverWorld){//在服务器端渲染粒子效果，需要获取目标离我们的距离
                double length = startpoint.distanceTo(endpoint);
                for (double d = 0; d <= length; d += 0.5){
                    Vec3d pos = startpoint.add(direction.multiply(d));
                    serverWorld.spawnParticles(ParticleTypes.SNOWFLAKE, pos.x, pos.y, pos.z, 1, 0, 0, 0, 1.0F);
                }
            }
            //接下来是随机数判断施加冰冻效果

        }
        user.getItemCooldownManager().set(stack.getItem(), COOLDOWN);
        return  TypedActionResult.success(stack, false);
    }

    private static @Nullable Entity findTarget(PlayerEntity user, Vec3d startpoint, Vec3d endpoint) {
        Entity nearest = null;
        double nearestDistance = startpoint.distanceTo(endpoint);
        // expand(1.0)：放宽盒子的预筛选范围，只靠下面的碰撞箱raycast做精确判断
        for (Entity entity : user.getWorld().getOtherEntities(user, new Box(startpoint, endpoint).expand(1.0), entity -> entity instanceof LivingEntity && !entity.isSpectator() && entity.canHit())) {
            Optional<Vec3d> hit = entity.getBoundingBox().raycast(startpoint, endpoint);
            if (hit.isPresent()) {//射线真的穿过了这个实体的碰撞箱
                double distance = startpoint.distanceTo(hit.get());
                if (distance < nearestDistance) {
                    nearest = entity;
                    nearestDistance = distance;
                }
            }
        }
        return nearest;
    }
}
