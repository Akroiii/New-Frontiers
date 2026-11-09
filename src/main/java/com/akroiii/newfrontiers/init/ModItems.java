package com.akroiii.newfrontiers.init;

import com.akroiii.newfrontiers.NewFrontiersMod;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(NewFrontiersMod.MODID);

    public static final DeferredItem<BlockItem> SALT_ITEM = ITEMS.registerSimpleBlockItem(
            "salt", ModBlocks.SALT_BLOCK);

    public static final DeferredItem<BlockItem> CHALK_ITEM = ITEMS.registerSimpleBlockItem(
            "chalk", ModBlocks.CHALK);

    public static final DeferredItem<BlockItem> CHALK_STAIRS_ITEM = ITEMS.registerSimpleBlockItem(
            "chalk_stairs", ModBlocks.CHALK_STAIRS);

    public static final DeferredItem<BlockItem> CHALK_SLAB_ITEM = ITEMS.registerSimpleBlockItem(
            "chalk_slab", ModBlocks.CHALK_SLAB);

    public static final DeferredItem<BlockItem> CHALK_WALL_ITEM = ITEMS.registerSimpleBlockItem(
            "chalk_wall", ModBlocks.CHALK_WALL);
}
