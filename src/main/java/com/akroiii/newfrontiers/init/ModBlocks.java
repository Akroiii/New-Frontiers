package com.akroiii.newfrontiers.init;

import com.akroiii.newfrontiers.NewFrontiersMod;
import com.akroiii.newfrontiers.block.SaltBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NewFrontiersMod.MODID);

    public static final DeferredBlock<SaltBlock> SALT_BLOCK = BLOCKS.register(
            "salt",
            () -> new SaltBlock(
                    BlockBehaviour.Properties.of()
                            .strength(0.5F, 0.5F)
                            .sound(SoundType.SAND)
                            .mapColor(MapColor.QUARTZ)
            )
    );
}
