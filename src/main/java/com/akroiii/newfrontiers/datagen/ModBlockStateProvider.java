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
        // Sale (mettiamo la texture della sabbia per non farlo crashare)
        ResourceLocation sandTexture = ResourceLocation.withDefaultNamespace("block/sand");
        simpleBlockWithItem(ModBlocks.SALT_BLOCK.get(), models().cubeAll("salt", sandTexture));

        // Chalk e varianti (usano la texture "chalk" che creeremo)
        simpleBlockWithItem(ModBlocks.CHALK.get(), models().cubeAll("chalk", modLoc("block/chalk")));
        stairsBlock(ModBlocks.CHALK_STAIRS.get(), modLoc("block/chalk"));
        slabBlock(ModBlocks.CHALK_SLAB.get(), modLoc("block/chalk"), modLoc("block/chalk"));
        wallBlock(ModBlocks.CHALK_WALL.get(), modLoc("block/chalk"));
    }
}
