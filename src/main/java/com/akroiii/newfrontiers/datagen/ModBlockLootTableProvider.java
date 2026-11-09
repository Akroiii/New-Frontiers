package com.akroiii.newfrontiers.datagen;

import com.akroiii.newfrontiers.NewFrontiersMod;
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
                                dropSelf(NewFrontiersMod.SALT_BLOCK.get());
                                    }

                                        @Override
                                            protected Iterable<Block> getKnownBlocks() {
                                                    return NewFrontiersMod.BLOCKS.getEntries().stream()
                                                                    .map(holder -> (Block) holder.get())
                                                                                    .collect(Collectors.toList());
                                                                                        }
                                                                                        }