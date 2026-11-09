package com.akroiii.newfrontiers;

import org.slf4j.Logger;
import com.mojang.logging.LogUtils;

import com.akroiii.newfrontiers.init.ModBlocks;
import com.akroiii.newfrontiers.init.ModItems;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(NewFrontiersMod.MODID)
public class NewFrontiersMod {
    public static final String MODID = "newfrontiers";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> NEW_FRONTIERS_TAB =
            CREATIVE_MODE_TABS.register("new_frontiers_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.newfrontiers"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.SALT_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        // QUI AGGIUNGI TUTTI I BLOCCHI
                        output.accept(ModItems.SALT_ITEM.get());
                        output.accept(ModItems.CHALK_ITEM.get());
                        output.accept(ModItems.CHALK_STAIRS_ITEM.get());
                        output.accept(ModItems.CHALK_SLAB_ITEM.get());
                        output.accept(ModItems.CHALK_WALL_ITEM.get());
                    }).build());

    public NewFrontiersMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);
        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
