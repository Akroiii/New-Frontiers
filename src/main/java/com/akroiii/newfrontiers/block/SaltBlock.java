package com.akroiii.newfrontiers.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SaltBlock extends FallingBlock {

    public static final MapCodec<SaltBlock> CODEC = simpleCodec(SaltBlock::new);

    public SaltBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return CODEC;
    }
}
