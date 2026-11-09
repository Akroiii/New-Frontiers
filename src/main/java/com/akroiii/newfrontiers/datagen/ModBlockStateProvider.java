package com.akroiii.newfrontiers.datagen;

import com.akroiii.newfrontiers.NewFrontiersMod;
import com.akroiii.newfrontiers.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NewFrontiersMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlockWithItem(ModBlocks.SALT_BLOCK.get(),
                cubeAll(ModBlocks.SALT_BLOCK.get()));
    }
}
