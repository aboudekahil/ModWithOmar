package com.aboudeOmar.ourMod;


import com.aboudeOmar.ourMod.items.CustomItem;
import com.aboudeOmar.ourMod.items.LevSword;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OurMod implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("Aboude Omar mod");
    public static final CustomItem MY_ITEM = new CustomItem(new FabricItemSettings());
    public static final LevSword LEV_SWORD = new LevSword(new FabricItemSettings());
    public static final Item FDPO = new Item(
            new FabricItemSettings().food(
                    new FoodComponent.Builder().hunger(5).saturationModifier(6f).alwaysEdible().snack().statusEffect(
                            new StatusEffectInstance(StatusEffects.POISON,20*600), 1f).statusEffect(
                            new StatusEffectInstance(StatusEffects.NAUSEA,20*600), 1f).build()));

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");
        Registry.register(Registries.ITEM, new Identifier("tutorial", "custom_item"), MY_ITEM);
        Registry.register(Registries.ITEM, new Identifier("tutorial", "food_potion"), FDPO);
        Registry.register(Registries.ITEM, new Identifier("tutorial", "lev_sword"), LEV_SWORD);
    }

}
