package com.akroiii.newfrontiers.init;

import com.akroiii.newfrontiers.NewFrontiersMod;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(NewFrontiersMod.MODID);

    public static final DeferredItem<BlockItem> SALT_ITEM = ITEMS.registerSimpleBlockItem(
            "salt",
            ModBlocks.SALT_BLOCK
    );
}
