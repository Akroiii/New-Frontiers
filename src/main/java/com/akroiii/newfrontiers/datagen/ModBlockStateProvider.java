package com.akroiii.newfrontiers.datagen;

import com.akroiii.newfrontiers.NewFrontiersMod;
import com.akroiii.newfrontiers.init.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, NewFrontiersMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Sale
        ResourceLocation sandTexture = ResourceLocation.withDefaultNamespace("block/sand");
        simpleBlockWithItem(ModBlocks.SALT_BLOCK.get(), models().cubeAll("salt", sandTexture));

        // Chalk (Blocco base)
        simpleBlockWithItem(ModBlocks.CHALK.get(), models().cubeAll("chalk", modLoc("block/chalk")));

        // Chalk Stairs
        stairsBlock(ModBlocks.CHALK_STAIRS.get(), modLoc("block/chalk"));
        itemModels().withExistingParent("chalk_stairs", modLoc("block/chalk_stairs"));

        // Chalk Slab
        slabBlock(ModBlocks.CHALK_SLAB.get(), modLoc("block/chalk"), modLoc("block/chalk"));
        itemModels().withExistingParent("chalk_slab", modLoc("block/chalk_slab"));

        // Chalk Wall
        wallBlock(ModBlocks.CHALK_WALL.get(), modLoc("block/chalk"));
        itemModels().withExistingParent("chalk_wall", modLoc("block/chalk_wall"));
    }
}
