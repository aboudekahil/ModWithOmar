package com.aboudeOmar.ourMod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomItem extends Item {
    private static int jumpCount = 0;
    public static final Logger LOGGER = LoggerFactory.getLogger("CustomItem");
    public CustomItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.BLOCK_WOOL_BREAK, 1.0F, 1.0F);
        if(world.isClient() && (playerEntity.isOnGround() || jumpCount == 1)){
            jumpCount++;
            LOGGER.info("" + jumpCount);
            playerEntity.jump();
        }

        jumpCount %= 2;

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}
