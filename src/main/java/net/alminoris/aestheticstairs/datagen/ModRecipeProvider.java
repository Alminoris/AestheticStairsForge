package net.alminoris.aestheticstairs.datagen;

import net.alminoris.aestheticstairs.block.ModBlocks;
import net.alminoris.aestheticstairs.item.ModItemGroups;
import net.alminoris.aestheticstairs.item.ModItems;
import net.alminoris.aestheticstairs.util.helper.BlockSetsHelper;
import net.alminoris.aestheticstairs.util.helper.ModJsonHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    private static final Dictionary<String, Block> SECONDARY_STONES = new Hashtable<>()
    {{
        put("stone", Blocks.COBBLESTONE);
        put("tuff", Blocks.TUFF);
        put("blackstone", Blocks.POLISHED_BLACKSTONE);
        put("andesite", Blocks.POLISHED_ANDESITE);
        put("diorite", Blocks.POLISHED_DIORITE);
        put("granite", Blocks.POLISHED_GRANITE);
        put("deepslate", Blocks.POLISHED_DEEPSLATE);
        put("basalt_side", Blocks.SMOOTH_BASALT);
        put("quartz_block_bottom", Blocks.QUARTZ_PILLAR);
        put("stone_bricks", Blocks.SMOOTH_STONE);
        put("bricks", Blocks.CHISELED_STONE_BRICKS);
        put("mud_bricks", Blocks.PACKED_MUD);
        put("sandstone", Blocks.SANDSTONE);
    }};
    
    public ModRecipeProvider(DataGenerator pOutput)
    {
        super(pOutput);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeExporter)
    {
        for(String name : BlockSetsHelper.STONES)
        {
            Block block = ForgeRegistries.BLOCKS.getValue(ResourceLocation.withDefaultNamespace(name.equals("basalt_side") ? "basalt" :
                    (name.equals("quartz_block_bottom") ? "quartz_block" : name)));

            ShapedRecipeBuilder.shaped(ModBlocks.SMALL_STAIRS.get(name).get(), 3)
                    .define('#', block)
                    .pattern("# ")
                    .pattern("##")
                    .unlockedBy(getHasName(block), has(block))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SMALL_HALFSTAIRS.get(name).get(), 3)
                    .define('#', block)
                    .pattern("# ")
                    .pattern(" #")
                    .unlockedBy(getHasName(block), has(block))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.STAIRCASES.get(name).get(), 3)
                    .define('#', block)
                    .define('/', SECONDARY_STONES.get(name))
                    .pattern("#  ")
                    .pattern("/# ")
                    .pattern(" /#")
                    .unlockedBy(getHasName(block), has(block))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SMALL_STAIRCASES.get(name).get(), 3)
                    .define('#', block)
                    .define('/', SECONDARY_STONES.get(name))
                    .pattern("# ")
                    .pattern("/#")
                    .unlockedBy(getHasName(block), has(block))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.STAIRAILS.get(name).get(), 4)
                    .define('#', block)
                    .define('/', SECONDARY_STONES.get(name))
                    .pattern("/#/")
                    .pattern("/#/")
                    .unlockedBy(getHasName(block), has(block))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SMALL_STAIRAILS.get(name).get(), 3)
                    .define('#', block)
                    .define('/', SECONDARY_STONES.get(name))
                    .pattern("/#/")
                    .unlockedBy(getHasName(block), has(block))
                    .save(recipeExporter);
        }

        for(String name : ModItemGroups.EXTRA_STONES_WF)
        {
            ModJsonHelper.createShapedRecipe("small_stairs_"+name, "3", "wildfields:" + name,
                    "\"#  \",", "\"## \"", "");

            ModJsonHelper.createShapedRecipe("small_halfstairs_"+name, "3", "wildfields:" + name,
                    "\"#  \",", "\" # \"", "");

            ModJsonHelper.createShapedRecipe("staircase_"+name, "3", "wildfields:" + name, "wildfields:" + name.replace("block", "cobbled"),
                    "\"#  \",", "\"/# \",", "\" /#\"");

            ModJsonHelper.createShapedRecipe("small_staircase_"+name, "3", "wildfields:" + name, "wildfields:" + name.replace("block", "cobbled"),
                    "\"# \",", "\"/#\"", "");

            ModJsonHelper.createShapedRecipe("stairail_"+name, "3", "wildfields:" + name, "wildfields:" + name.replace("block", "cobbled"),
                    "\"/#/\",", "\"/#/\"", "");

            ModJsonHelper.createShapedRecipe("small_stairail_"+name, "3", "wildfields:" + name, "wildfields:" + name.replace("block", "cobbled"),
                    "\"/#/\"", "", "");
        }

        for(String name : BlockSetsHelper.WOODS)
        {
            String blockName = (name.equals("crimson") || name.equals("warped")) ? "stem" : (name.equals("bamboo") ? "block" : "log");
            Block block = ForgeRegistries.BLOCKS.getValue(ResourceLocation.withDefaultNamespace("stripped_"+name+"_"+blockName));
            Block block1 = ForgeRegistries.BLOCKS.getValue(ResourceLocation.withDefaultNamespace(name+"_planks"));

            ShapedRecipeBuilder.shaped(ModBlocks.SMALL_STAIRS.get(name).get(), 3)
                    .define('#', block1)
                    .pattern("# ")
                    .pattern("##")
                    .unlockedBy(getHasName(block1), has(block1))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SMALL_HALFSTAIRS.get(name).get(), 3)
                    .define('#', block1)
                    .pattern("# ")
                    .pattern(" #")
                    .unlockedBy(getHasName(block1), has(block1))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.STAIRCASES.get(name).get(), 3)
                    .define('#', block)
                    .define('/', Items.STICK)
                    .pattern("#  ")
                    .pattern("/# ")
                    .pattern(" /#")
                    .unlockedBy(getHasName(block), has(block))
                    .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SMALL_STAIRCASES.get(name).get(), 3)
                    .define('#', block)
                    .define('/', Items.STICK)
                    .pattern("# ")
                    .pattern("/#")
                    .unlockedBy(getHasName(block), has(block))
                    .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.STAIRAILS.get(name).get(), 4)
                    .define('#', block)
                    .define('/', Items.STICK)
                    .pattern("/#/")
                    .pattern("/#/")
                    .unlockedBy(getHasName(block), has(block))
                    .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                    .save(recipeExporter);

            ShapedRecipeBuilder.shaped(ModBlocks.SMALL_STAIRAILS.get(name).get(), 3)
                    .define('#', block)
                    .define('/', Items.STICK)
                    .pattern("/#/")
                    .unlockedBy(getHasName(block), has(block))
                    .unlockedBy(getHasName(Items.STICK), has(Items.STICK))
                    .save(recipeExporter);
        }

        for(String name : ModItemGroups.AN_WOOD_NAMES)
        {
            ModJsonHelper.createShapedRecipe("small_stairs_"+name, "3", "arborealnature:" + name + "_planks",
                    "\"#  \",", "\"## \"", "");

            ModJsonHelper.createShapedRecipe("small_halfstairs_"+name, "3", "arborealnature:" + name + "_planks",
                    "\"#  \",", "\" # \"", "");

            ModJsonHelper.createShapedRecipe("staircase_"+name, "3", "arborealnature:stripped_" + name + "_log", "minecraft:stick",
                    "\"#  \",", "\"/# \",", "\" /#\"");

            ModJsonHelper.createShapedRecipe("small_staircase_"+name, "3", "arborealnature:stripped_" + name + "_log", "minecraft:stick",
                    "\"# \",", "\"/#\"", "");

            ModJsonHelper.createShapedRecipe("stairail_"+name, "3", "arborealnature:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\",", "\"/#/\"", "");

            ModJsonHelper.createShapedRecipe("small_stairail_"+name, "3", "arborealnature:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\"", "", "");
        }

        for(String name : ModItemGroups.WF_WOOD_NAMES)
        {
            ModJsonHelper.createShapedRecipe("small_stairs_"+name, "3", "wildfields:" + name + "_planks",
                    "\"#  \",", "\"## \"", "");

            ModJsonHelper.createShapedRecipe("small_halfstairs_"+name, "3", "wildfields:" + name + "_planks",
                    "\"#  \",", "\" # \"", "");

            ModJsonHelper.createShapedRecipe("staircase_"+name, "3", "wildfields:stripped_" + name + "_log", "minecraft:stick",
                    "\"#  \",", "\"/# \",", "\" /#\"");

            ModJsonHelper.createShapedRecipe("small_staircase_"+name, "3", "wildfields:stripped_" + name + "_log", "minecraft:stick",
                    "\"# \",", "\"/#\"", "");

            ModJsonHelper.createShapedRecipe("stairail_"+name, "3", "wildfields:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\",", "\"/#/\"", "");

            ModJsonHelper.createShapedRecipe("small_stairail_"+name, "3", "wildfields:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\"", "", "");
        }

        for(String name : ModItemGroups.ST_WOOD_NAMES)
        {
            ModJsonHelper.createShapedRecipe("small_stairs_"+name, "3", "silverwoodtrees:" + name + "_planks",
                    "\"#  \",", "\"## \"", "");

            ModJsonHelper.createShapedRecipe("small_halfstairs_"+name, "3", "silverwoodtrees:" + name + "_planks",
                    "\"#  \",", "\" # \"", "");

            ModJsonHelper.createShapedRecipe("staircase_"+name, "3", "silverwoodtrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"#  \",", "\"/# \",", "\" /#\"");

            ModJsonHelper.createShapedRecipe("small_staircase_"+name, "3", "silverwoodtrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"# \",", "\"/#\"", "");

            ModJsonHelper.createShapedRecipe("stairail_"+name, "3", "silverwoodtrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\",", "\"/#/\"", "");

            ModJsonHelper.createShapedRecipe("small_stairail_"+name, "3", "silverwoodtrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\"", "", "");
        }

        for(String name : ModItemGroups.WT_WOOD_NAMES)
        {
            ModJsonHelper.createShapedRecipe("small_stairs_"+name, "3", "whisperleaftrees:" + name + "_planks",
                    "\"#  \",", "\"## \"", "");

            ModJsonHelper.createShapedRecipe("small_halfstairs_"+name, "3", "whisperleaftrees:" + name + "_planks",
                    "\"#  \",", "\" # \"", "");

            ModJsonHelper.createShapedRecipe("staircase_"+name, "3", "whisperleaftrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"#  \",", "\"/# \",", "\" /#\"");

            ModJsonHelper.createShapedRecipe("small_staircase_"+name, "3", "whisperleaftrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"# \",", "\"/#\"", "");

            ModJsonHelper.createShapedRecipe("stairail_"+name, "3", "whisperleaftrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\",", "\"/#/\"", "");

            ModJsonHelper.createShapedRecipe("small_stairail_"+name, "3", "whisperleaftrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\"", "", "");
        }

        for(String name : ModItemGroups.MT_WOOD_NAMES)
        {
            ModJsonHelper.createShapedRecipe("small_stairs_"+name, "3", "missingtrees:" + name + "_planks",
                    "\"#  \",", "\"## \"", "");

            ModJsonHelper.createShapedRecipe("small_halfstairs_"+name, "3", "missingtrees:" + name + "_planks",
                    "\"#  \",", "\" # \"", "");

            ModJsonHelper.createShapedRecipe("staircase_"+name, "3", "missingtrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"#  \",", "\"/# \",", "\" /#\"");

            ModJsonHelper.createShapedRecipe("small_staircase_"+name, "3", "missingtrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"# \",", "\"/#\"", "");

            ModJsonHelper.createShapedRecipe("stairail_"+name, "3", "missingtrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\",", "\"/#/\"", "");

            ModJsonHelper.createShapedRecipe("small_stairail_"+name, "3", "missingtrees:stripped_" + name + "_log", "minecraft:stick",
                    "\"/#/\"", "", "");
        }

        for(String name : ModItemGroups.NSS_WOOD_NAMES)
        {
            ModJsonHelper.createShapedRecipe("small_stairs_"+name, "3", "natures_spirit:" + name.replace("_nss", "") + "_planks",
                    "\"#  \",", "\"## \"", "");

            ModJsonHelper.createShapedRecipe("small_halfstairs_"+name, "3", "natures_spirit:" + name.replace("_nss", "") + "_planks",
                    "\"#  \",", "\" # \"", "");

            ModJsonHelper.createShapedRecipe("staircase_"+name, "3", "natures_spirit:stripped_" + name.replace("_nss", "") + "_log", "minecraft:stick",
                    "\"#  \",", "\"/# \",", "\" /#\"");

            ModJsonHelper.createShapedRecipe("small_staircase_"+name, "3", "natures_spirit:stripped_" + name.replace("_nss", "") + "_log", "minecraft:stick",
                    "\"# \",", "\"/#\"", "");

            ModJsonHelper.createShapedRecipe("stairail_"+name, "3", "natures_spirit:stripped_" + name.replace("_nss", "") + "_log", "minecraft:stick",
                    "\"/#/\",", "\"/#/\"", "");

            ModJsonHelper.createShapedRecipe("small_stairail_"+name, "3", "natures_spirit:stripped_" + name.replace("_nss", "") + "_log", "minecraft:stick",
                    "\"/#/\"", "", "");
        }
    }
}