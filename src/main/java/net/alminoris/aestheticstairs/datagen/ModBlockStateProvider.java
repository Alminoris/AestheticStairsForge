package net.alminoris.aestheticstairs.datagen;

import net.alminoris.aestheticstairs.AestheticStairs;
import net.alminoris.aestheticstairs.block.ModBlocks;
import net.alminoris.aestheticstairs.item.ModItemGroups;
import net.alminoris.aestheticstairs.util.helper.BlockSetsHelper;
import net.alminoris.aestheticstairs.util.helper.ModJsonHelper;
import net.alminoris.aestheticstairs.util.helper.ModJsonTemplates;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.Dictionary;
import java.util.Hashtable;

public class ModBlockStateProvider extends BlockStateProvider
{
    private static final Dictionary<String, String> SECONDARY_STONES = new Hashtable<>()
    {{
        put("stone", "cobblestone");
        put("tuff", "tuff");
        put("blackstone", "polished_blackstone");
        put("andesite", "polished_andesite");
        put("diorite", "polished_diorite");
        put("granite", "polished_granite");
        put("deepslate", "cobbled_deepslate");
        put("basalt_side", "smooth_basalt");
        put("quartz_block_bottom", "quartz_pillar");
        put("stone_bricks", "stonecutter_bottom");
        put("bricks", "chiseled_stone_bricks");
        put("mud_bricks", "packed_mud");
        put("sandstone", "sandstone_bottom");
    }};

    public ModBlockStateProvider(DataGenerator output, ExistingFileHelper exFileHelper)
    {
        super(output, AestheticStairs.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        for(String name : BlockSetsHelper.STONES)
        {
            registerStaircase(ModBlocks.STAIRCASES.get(name),"minecraft:block/", "staircase_"+name, name, SECONDARY_STONES.get(name));
            registerSmallStaircase(ModBlocks.SMALL_STAIRCASES.get(name),"minecraft:block/", "small_staircase_"+name, name, SECONDARY_STONES.get(name));

            registerStairail(ModBlocks.STAIRAILS.get(name),"minecraft:block/", "stairail_"+name, name, SECONDARY_STONES.get(name));
            registerSmallStairail(ModBlocks.SMALL_STAIRAILS.get(name),"minecraft:block/", "small_stairail_"+name, name, SECONDARY_STONES.get(name));

            registerSmallStairs(ModBlocks.SMALL_STAIRS.get(name), ModBlocks.SMALL_HALFSTAIRS.get(name), "minecraft:block/", name, name);
        }

        for(String name : ModItemGroups.EXTRA_STONES_WF)
        {
            registerStaircase( ModBlocks.STAIRCASES.get(name),"aestheticstairs:block/", "staircase_"+name, name, name.replace("block", "cobbled"));
            registerSmallStaircase( ModBlocks.SMALL_STAIRCASES.get(name),"aestheticstairs:block/", "small_staircase_"+name, name, name.replace("block", "cobbled"));

            registerStairail( ModBlocks.STAIRAILS.get(name),"aestheticstairs:block/", "stairail_"+name, name, name.replace("block", "cobbled"));
            registerSmallStairail( ModBlocks.SMALL_STAIRAILS.get(name),"aestheticstairs:block/", "small_stairail_"+name, name, name.replace("block", "cobbled"));

            registerSmallStairs(ModBlocks.SMALL_STAIRS.get(name), ModBlocks.SMALL_HALFSTAIRS.get(name), "aestheticstairs:block/", name, name);
        }

        for(String name : BlockSetsHelper.WOODS)
        {
            String logName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");
            registerStaircase( ModBlocks.STAIRCASES.get(name),"minecraft:block/", "staircase_"+name, "stripped_"+name+"_"+logName, name+"_"+logName);
            registerSmallStaircase( ModBlocks.SMALL_STAIRCASES.get(name),"minecraft:block/", "small_staircase_"+name, "stripped_"+name+"_"+logName, name+"_"+logName);

            registerStairail( ModBlocks.STAIRAILS.get(name),"minecraft:block/", "stairail_"+name, "stripped_"+name+"_"+logName, name+"_"+logName);
            registerSmallStairail( ModBlocks.SMALL_STAIRAILS.get(name),"minecraft:block/", "small_stairail_"+name, "stripped_"+name+"_"+logName, name+"_"+logName);

            registerSmallStairs(ModBlocks.SMALL_STAIRS.get(name), ModBlocks.SMALL_HALFSTAIRS.get(name), "minecraft:block/", name, name+"_planks");
        }

        for(String name : ModItemGroups.AN_WOOD_NAMES)
        {
            registerStaircase( ModBlocks.STAIRCASES.get(name),"aestheticstairs:block/", "staircase_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStaircase( ModBlocks.SMALL_STAIRCASES.get(name),"aestheticstairs:block/", "small_staircase_"+name, "stripped_"+name+"_log", name+"_log");

            registerStairail( ModBlocks.STAIRAILS.get(name),"aestheticstairs:block/", "stairail_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStairail( ModBlocks.SMALL_STAIRAILS.get(name),"aestheticstairs:block/", "small_stairail_"+name, "stripped_"+name+"_log", name+"_log");

            registerSmallStairs(ModBlocks.SMALL_STAIRS.get(name), ModBlocks.SMALL_HALFSTAIRS.get(name), "aestheticstairs:block/", name, name+"_planks");
        }

        for(String name : ModItemGroups.WF_WOOD_NAMES)
        {
            registerStaircase(ModBlocks.STAIRCASES.get(name), "aestheticstairs:block/", "staircase_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStaircase( ModBlocks.SMALL_STAIRCASES.get(name),"aestheticstairs:block/", "small_staircase_"+name, "stripped_"+name+"_log", name+"_log");

            registerStairail( ModBlocks.STAIRAILS.get(name),"aestheticstairs:block/", "stairail_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStairail( ModBlocks.SMALL_STAIRAILS.get(name),"aestheticstairs:block/", "small_stairail_"+name, "stripped_"+name+"_log", name+"_log");

            registerSmallStairs(ModBlocks.SMALL_STAIRS.get(name), ModBlocks.SMALL_HALFSTAIRS.get(name), "aestheticstairs:block/", name, name+"_planks");
        }

        for(String name : ModItemGroups.ST_WOOD_NAMES)
        {
            registerStaircase(ModBlocks.STAIRCASES.get(name), "aestheticstairs:block/", "staircase_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStaircase( ModBlocks.SMALL_STAIRCASES.get(name),"aestheticstairs:block/", "small_staircase_"+name, "stripped_"+name+"_log", name+"_log");

            registerStairail( ModBlocks.STAIRAILS.get(name),"aestheticstairs:block/", "stairail_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStairail( ModBlocks.SMALL_STAIRAILS.get(name),"aestheticstairs:block/", "small_stairail_"+name, "stripped_"+name+"_log", name+"_log");

            registerSmallStairs(ModBlocks.SMALL_STAIRS.get(name), ModBlocks.SMALL_HALFSTAIRS.get(name), "aestheticstairs:block/", name, name+"_planks");
        }

        for(String name : ModItemGroups.WT_WOOD_NAMES)
        {
            registerStaircase(ModBlocks.STAIRCASES.get(name), "aestheticstairs:block/", "staircase_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStaircase( ModBlocks.SMALL_STAIRCASES.get(name),"aestheticstairs:block/", "small_staircase_"+name, "stripped_"+name+"_log", name+"_log");

            registerStairail( ModBlocks.STAIRAILS.get(name),"aestheticstairs:block/", "stairail_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStairail( ModBlocks.SMALL_STAIRAILS.get(name),"aestheticstairs:block/", "small_stairail_"+name, "stripped_"+name+"_log", name+"_log");

            registerSmallStairs(ModBlocks.SMALL_STAIRS.get(name), ModBlocks.SMALL_HALFSTAIRS.get(name), "aestheticstairs:block/", name, name+"_planks");
        }

        for(String name : ModItemGroups.MT_WOOD_NAMES)
        {
            registerStaircase(ModBlocks.STAIRCASES.get(name), "aestheticstairs:block/", "staircase_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStaircase( ModBlocks.SMALL_STAIRCASES.get(name),"aestheticstairs:block/", "small_staircase_"+name, "stripped_"+name+"_log", name+"_log");

            registerStairail( ModBlocks.STAIRAILS.get(name),"aestheticstairs:block/", "stairail_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStairail( ModBlocks.SMALL_STAIRAILS.get(name),"aestheticstairs:block/", "small_stairail_"+name, "stripped_"+name+"_log", name+"_log");

            registerSmallStairs(ModBlocks.SMALL_STAIRS.get(name), ModBlocks.SMALL_HALFSTAIRS.get(name), "aestheticstairs:block/", name, name+"_planks");
        }

        for(String name : ModItemGroups.NSS_WOOD_NAMES)
        {
            registerStaircase(ModBlocks.STAIRCASES.get(name), "aestheticstairs:block/", "staircase_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStaircase( ModBlocks.SMALL_STAIRCASES.get(name),"aestheticstairs:block/", "small_staircase_"+name, "stripped_"+name+"_log", name+"_log");

            registerStairail( ModBlocks.STAIRAILS.get(name),"aestheticstairs:block/", "stairail_"+name, "stripped_"+name+"_log", name+"_log");
            registerSmallStairail( ModBlocks.SMALL_STAIRAILS.get(name),"aestheticstairs:block/", "small_stairail_"+name, "stripped_"+name+"_log", name+"_log");

            registerSmallStairs(ModBlocks.SMALL_STAIRS.get(name), ModBlocks.SMALL_HALFSTAIRS.get(name), "aestheticstairs:block/", name, name+"_planks");
        }
    }

    public void registerSmallStairs(RegistryObject<Block> smallStairs, RegistryObject<Block> smallHalfStairs, String modId, String name, String baseName)
    {
        ModJsonHelper.createSmallStair(ModJsonTemplates.SMALL_STAIRS, "small_stairs_"+name, modId+baseName);
        ModJsonHelper.createSmallStair(ModJsonTemplates.SMALL_STAIRS_INNER, "small_stairs_"+name+"_inner", modId+baseName);
        ModJsonHelper.createSmallStair(ModJsonTemplates.SMALL_STAIRS_OUTER, "small_stairs_"+name+"_outer", modId+baseName);

        ModJsonHelper.createSmallStair(ModJsonTemplates.SMALL_HALFSTAIRS, "small_halfstairs_"+name, modId+baseName);
        ModJsonHelper.createSmallStair(ModJsonTemplates.SMALL_HALFSTAIRS_INNER, "small_halfstairs_"+name+"_inner", modId+baseName);
        ModJsonHelper.createSmallStair(ModJsonTemplates.SMALL_HALFSTAIRS_OUTER, "small_halfstairs_"+name+"_outer", modId+baseName);

        ModJsonHelper.createBlockstate(ModJsonTemplates.SMALL_STAIRS_BLOCKSTATE, "small_stairs_"+name);
        ModJsonHelper.createBlockstate(ModJsonTemplates.SMALL_STAIRS_BLOCKSTATE, "small_halfstairs_"+name);
        blockItem(smallStairs, "block/"+ "small_stairs_"+name);
        blockItem(smallHalfStairs, "block/"+ "small_halfstairs_"+name);
    }

    public void registerStaircase(RegistryObject<Block> block, String modId, String name, String baseName, String legName)
    {
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE, name, modId+baseName, modId+legName, "normal", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_LEFT, name, modId+baseName, modId+legName, "left", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_RIGHT, name, modId+baseName, modId+legName, "right", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_CENTER, name, modId+baseName, modId+legName, "center", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_UP, name, modId+baseName, modId+legName, "up", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_UPLEFT, name, modId+baseName, modId+legName, "upleft", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_UPRIGHT, name, modId+baseName, modId+legName, "upright", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_UPCENTER, name, modId+baseName, modId+legName, "upcenter", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_LEFTCORNER, name, modId+baseName, modId+legName, "leftcorner", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_RIGHTCORNER, name, modId+baseName, modId+legName, "rightcorner", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_RAILED, name, modId+baseName, modId+legName, "normal", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_LEFT_RAILED, name, modId+baseName, modId+legName, "left", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_RIGHT_RAILED, name, modId+baseName, modId+legName, "right", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_UP_RAILED, name, modId+baseName, modId+legName, "up", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_UPLEFT_RAILED, name, modId+baseName, modId+legName, "upleft", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRCASE_UPRIGHT_RAILED, name, modId+baseName, modId+legName, "upright", true);
        ModJsonHelper.createBlockstate(ModJsonTemplates.STAIRCASE_BLOCKSTATE, name);
        blockItem(block, "block/"+ name);
    }

    public void registerSmallStaircase(RegistryObject<Block> block, String modId, String name, String baseName, String legName)
    {
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE, name, modId+baseName, modId+legName, "normal", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_LEFT, name, modId+baseName, modId+legName, "left", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_RIGHT, name, modId+baseName, modId+legName, "right", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_CENTER, name, modId+baseName, modId+legName, "center", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_UP, name, modId+baseName, modId+legName, "up", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_UPLEFT, name, modId+baseName, modId+legName, "upleft", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_UPRIGHT, name, modId+baseName, modId+legName, "upright", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_UPCENTER, name, modId+baseName, modId+legName, "upcenter", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_LEFTCORNER, name, modId+baseName, modId+legName, "leftcorner", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_RIGHTCORNER, name, modId+baseName, modId+legName, "rightcorner", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_RAILED, name, modId+baseName, modId+legName, "normal", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_LEFT_RAILED, name, modId+baseName, modId+legName, "left", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_RIGHT_RAILED, name, modId+baseName, modId+legName, "right", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_UP_RAILED, name, modId+baseName, modId+legName, "up", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_UPLEFT_RAILED, name, modId+baseName, modId+legName, "upleft", true);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRCASE_UPRIGHT_RAILED, name, modId+baseName, modId+legName, "upright", true);
        ModJsonHelper.createBlockstate(ModJsonTemplates.STAIRCASE_BLOCKSTATE, name);
        blockItem(block, "block/"+ name);
    }

    public void registerStairail(RegistryObject<Block> block, String modId, String name, String baseName, String legName)
    {
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRAIL, name, modId+baseName, modId+legName, "normal", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRAIL_SIDE, name, modId+baseName, modId+legName, "side", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRAIL_LEFTCORNER, name, modId+baseName, modId+legName, "leftcorner", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.STAIRAIL_RIGHTCORNER, name, modId+baseName, modId+legName, "rightcorner", false);
        ModJsonHelper.createBlockstate(ModJsonTemplates.STAIRAIL_BLOCKSTATE, name);
        blockItem(block, "block/"+ name+"_side");
    }

    public void registerSmallStairail(RegistryObject<Block> block, String modId, String name, String baseName, String legName)
    {
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRAIL, name, modId+baseName, modId+legName, "normal", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRAIL_SIDE, name, modId+baseName, modId+legName, "side", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRAIL_LEFTCORNER, name, modId+baseName, modId+legName, "leftcorner", false);
        ModJsonHelper.createStaircase(ModJsonTemplates.SMALL_STAIRAIL_RIGHTCORNER, name, modId+baseName, modId+legName, "rightcorner", false);
        ModJsonHelper.createBlockstate(ModJsonTemplates.STAIRAIL_BLOCKSTATE, name);
        blockItem(block, "block/"+ name+"_side");
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String name)
    {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("aestheticstairs:" + name));
    }
}