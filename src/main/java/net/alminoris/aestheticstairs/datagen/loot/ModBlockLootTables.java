package net.alminoris.aestheticstairs.datagen.loot;

import net.alminoris.aestheticstairs.block.ModBlocks;
import net.alminoris.aestheticstairs.util.helper.BlockSetsHelper;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider
{
    public ModBlockLootTables()
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate()
    {
        for(String name : BlockSetsHelper.getWoodsNStones())
        {
            dropSelf(ModBlocks.SMALL_STAIRS.get(name).get());
            dropSelf(ModBlocks.SMALL_HALFSTAIRS.get(name).get());
            dropSelf(ModBlocks.STAIRCASES.get(name).get());
            dropSelf(ModBlocks.SMALL_STAIRCASES.get(name).get());
            dropSelf(ModBlocks.STAIRAILS.get(name).get());
            dropSelf(ModBlocks.SMALL_STAIRAILS.get(name).get());
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
