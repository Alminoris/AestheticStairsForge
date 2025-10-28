package net.alminoris.aestheticstairs.datagen;

import net.alminoris.aestheticstairs.block.ModBlocks;
import net.alminoris.aestheticstairs.util.helper.BlockSetsHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider
{
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
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