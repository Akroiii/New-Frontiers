package com.akroiii.newfrontiers.init;

import com.akroiii.newfrontiers.NewFrontiersMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NewFrontiersMod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> NEW_FRONTIERS_TAB =
            CREATIVE_MODE_TABS.register("new_frontiers_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.newfrontiers"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> ModItems.SALT_ITEM.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.SALT_ITEM.get());
                    }).build());
}
