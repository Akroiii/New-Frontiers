package com.akroiii.newfrontiers.init;

import com.akroiii.newfrontiers.NewFrontiersMod;
import com.akroiii.newfrontiers.block.SaltBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(NewFrontiersMod.MODID);

    // --- SALT ---
    public static final DeferredBlock<SaltBlock> SALT_BLOCK = BLOCKS.register(
            "salt",
            () -> new SaltBlock(
                    BlockBehaviour.Properties.of()
                            .strength(0.5F, 0.5F)
                            .sound(SoundType.SAND)
                            .mapColor(MapColor.QUARTZ)
            )
    );

    // --- CHALK ---
    private static final BlockBehaviour.Properties CHALK_PROPERTIES = BlockBehaviour.Properties.of()
            .strength(1.5F, 6.0F) // Proprietà della pietra
            .sound(SoundType.STONE)
            .mapColor(MapColor.QUARTZ)
            .requiresCorrectToolForDrops();

    public static final DeferredBlock<Block> CHALK = BLOCKS.registerSimpleBlock("chalk", CHALK_PROPERTIES);
    
    public static final DeferredBlock<StairBlock> CHALK_STAIRS = BLOCKS.register("chalk_stairs",
            () -> new StairBlock(CHALK.get().defaultBlockState(), CHALK_PROPERTIES));
            
    public static final DeferredBlock<SlabBlock> CHALK_SLAB = BLOCKS.register("chalk_slab",
            () -> new SlabBlock(CHALK_PROPERTIES));
            
    public static final DeferredBlock<WallBlock> CHALK_WALL = BLOCKS.register("chalk_wall",
            () -> new WallBlock(CHALK_PROPERTIES));
}
