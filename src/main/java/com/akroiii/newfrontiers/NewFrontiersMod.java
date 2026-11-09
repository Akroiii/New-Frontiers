package com.akroiii.newfrontiers;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(NewFrontiersMod.MODID)
public class NewFrontiersMod {
    public static final String MODID = "newfrontiers";
        public static final Logger LOGGER = LogUtils.getLogger();
            public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
                public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
                    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

                        // Salt block: behaves like sand, quartz map color
                            public static final DeferredBlock<FallingBlock> SALT_BLOCK = BLOCKS.register(
                                        "salt",
                                                    () -> new FallingBlock(
                                                                        BlockBehaviour.Properties.of()
                                                                                                    .strength(0.5F, 0.5F)
                                                                                                                                .sound(SoundType.SAND)
                                                                                                                                                            .mapColor(MapColor.QUARTZ)
                                                                                                                                                                        )
                                                                                                                                                                            );

                                                                                                                                                                                public static final DeferredItem<BlockItem> SALT_ITEM = ITEMS.registerSimpleBlockItem(
                                                                                                                                                                                            "salt",
                                                                                                                                                                                                        SALT_BLOCK
                                                                                                                                                                                                            );

                                                                                                                                                                                                                // New Frontiers creative tab
                                                                                                                                                                                                                    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> NEW_FRONTIERS_TAB = CREATIVE_MODE_TABS.register("new_frontiers_tab", () -> CreativeModeTab.builder()
                                                                                                                                                                                                                                .title(Component.translatable("itemGroup.newfrontiers"))
                                                                                                                                                                                                                                            .withTabsBefore(CreativeModeTabs.COMBAT)
                                                                                                                                                                                                                                                        .icon(() -> SALT_ITEM.get().getDefaultInstance())
                                                                                                                                                                                                                                                                    .displayItems((parameters, output) -> {
                                                                                                                                                                                                                                                                                    output.accept(SALT_ITEM.get());
                                                                                                                                                                                                                                                                                                }).build());

                                                                                                                                                                                                                                                                                                    public NewFrontiersMod(IEventBus modEventBus, ModContainer modContainer) {
                                                                                                                                                                                                                                                                                                            modEventBus.addListener(this::commonSetup);
                                                                                                                                                                                                                                                                                                                    BLOCKS.register(modEventBus);
                                                                                                                                                                                                                                                                                                                            ITEMS.register(modEventBus);
                                                                                                                                                                                                                                                                                                                                    CREATIVE_MODE_TABS.register(modEventBus);
                                                                                                                                                                                                                                                                                                                                            NeoForge.EVENT_BUS.register(this);
                                                                                                                                                                                                                                                                                                                                                    modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                            private void commonSetup(FMLCommonSetupEvent event) {
                                                                                                                                                                                                                                                                                                                                                                    LOGGER.info("HELLO FROM COMMON SETUP");
                                                                                                                                                                                                                                                                                                                                                                            if (Config.LOG_DIRT_BLOCK.getAsBoolean()) {
                                                                                                                                                                                                                                                                                                                                                                                        LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                        LOGGER.info("{}{}", Config.MAGIC_NUMBER_INTRODUCTION.get(), Config.MAGIC_NUMBER.getAsInt());
                                                                                                                                                                                                                                                                                                                                                                                                                Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
                                                                                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                                                                                        @SubscribeEvent
                                                                                                                                                                                                                                                                                                                                                                                                                            public void onServerStarting(ServerStartingEvent event) {
                                                                                                                                                                                                                                                                                                                                                                                                                                    LOGGER.info("HELLO from server starting");
                                                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                                                        }