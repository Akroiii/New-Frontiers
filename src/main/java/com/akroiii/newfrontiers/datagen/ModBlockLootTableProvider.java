package com.akroiii.newfrontiers.datagen;

import com.akroiii.newfrontiers.init.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SALT_BLOCK.get());
        
        dropSelf(ModBlocks.CHALK.get());
        dropSelf(ModBlocks.CHALK_STAIRS.get());
        dropSelf(ModBlocks.CHALK_WALL.get());
        // La lastra ha bisogno di una regola speciale per il doppio blocco
        add(ModBlocks.CHALK_SLAB.get(), createSlabItemTable(ModBlocks.CHALK_SLAB.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream()
                .map(holder -> (Block) holder.get())
                .collect(Collectors.toList());
    }
}
