package com.akroiii.newfrontiers.datagen;

import com.akroiii.newfrontiers.NewFrontiersMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {
    public ModLanguageProvider(PackOutput output) {
            super(output, NewFrontiersMod.MODID, "en_us");
                }

                    @Override
                        protected void addTranslations() {
                                add("block.newfrontiers.salt", "Salt");
                                        add("itemGroup.newfrontiers", "New Frontiers");
                                            }
                                            }