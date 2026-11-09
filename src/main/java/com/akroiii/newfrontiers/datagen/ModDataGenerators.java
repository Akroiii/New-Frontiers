package com.akroiii.newfrontiers.datagen;

import com.akroiii.newfrontiers.NewFrontiersMod;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = NewFrontiersMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {

    @SubscribeEvent
        public static void gatherData(GatherDataEvent event) {
                var generator = event.getGenerator();
                        var output = generator.getPackOutput();
                                var existingFileHelper = event.getExistingFileHelper();
                                        var lookupProvider = event.getLookupProvider();

                                                generator.addProvider(event.includeClient(),
                                                                new ModBlockStateProvider(output, existingFileHelper));
                                                                        generator.addProvider(event.includeClient(),
                                                                                        new ModLanguageProvider(output));

                                                                                                generator.addProvider(event.includeServer(),
                                                                                                                new LootTableProvider(output, Set.of(), List.of(
                                                                                                                                        new LootTableProvider.SubProviderEntry(
                                                                                                                                                                        ModBlockLootTableProvider::new,
                                                                                                                                                                                                        LootContextParamSets.BLOCK
                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                ), lookupProvider));
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    }