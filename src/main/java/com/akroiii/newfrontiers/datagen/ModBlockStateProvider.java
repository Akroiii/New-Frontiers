package com.akroiii.newfrontiers.datagen;

import com.akroiii.newfrontiers.NewFrontiersMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
            super(output, NewFrontiersMod.MODID, exFileHelper);
                }

                    @Override
                        protected void registerStatesAndModels() {
                                simpleBlockWithItem(NewFrontiersMod.SALT_BLOCK.get(),
                                                cubeAll(NewFrontiersMod.SALT_BLOCK.get()));
                                                    }
                                                    }