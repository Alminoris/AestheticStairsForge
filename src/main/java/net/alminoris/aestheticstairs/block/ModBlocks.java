package net.alminoris.aestheticstairs.block;

import net.alminoris.aestheticstairs.AestheticStairs;
import net.alminoris.aestheticstairs.block.custom.StairailBlock;
import net.alminoris.aestheticstairs.block.custom.StaircaseBlock;
import net.alminoris.aestheticstairs.item.ModItems;
import net.alminoris.aestheticstairs.util.helper.BlockSetsHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.function.Supplier;

public class ModBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, AestheticStairs.MOD_ID);

    public static final Dictionary<String, RegistryObject<Block>> SMALL_STAIRS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("small_stairs_"+name,
                    () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion())));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("small_stairs_"+name,
                    () -> new StairBlock(Blocks.STONE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion())));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SMALL_HALFSTAIRS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("small_halfstairs_"+name,
                    () -> new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion())));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("small_halfstairs_"+name,
                    () -> new StairBlock(Blocks.STONE.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).noOcclusion())));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> STAIRCASES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("staircase_"+name, () -> new StaircaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), name, "staircase_"+name)));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("staircase_"+name, () -> new StaircaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), name, "staircase_"+name)));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SMALL_STAIRCASES = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("small_staircase_"+name, () -> new StaircaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), name, "small_staircase_"+name)));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("small_staircase_"+name, () -> new StaircaseBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), name, "small_staircase_"+name)));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> STAIRAILS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("stairail_"+name, () -> new StairailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), "stairail_"+name)));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("stairail_"+name, () -> new StairailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), "stairail_"+name)));
        }
    }};

    public static final Dictionary<String, RegistryObject<Block>> SMALL_STAIRAILS = new Hashtable<>()
    {{
        for(String name : BlockSetsHelper.getWoods())
        {
            put(name, registerBlock("small_stairail_"+name, () -> new StairailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS), "small_stairail"+name)));
        }

        for(String name : BlockSetsHelper.getStones())
        {
            put(name, registerBlock("small_stairail_"+name, () -> new StairailBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE), "small_stairail"+name)));
        }
    }};

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
    {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}