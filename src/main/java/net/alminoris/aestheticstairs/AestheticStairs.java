package net.alminoris.aestheticstairs;

import com.mojang.logging.LogUtils;
import net.alminoris.aestheticstairs.block.ModBlocks;
import net.alminoris.aestheticstairs.item.ModItemGroups;
import net.alminoris.aestheticstairs.item.ModItems;
import net.alminoris.aestheticstairs.util.helper.BlockSetsHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static net.alminoris.aestheticstairs.util.helper.BlockSetsHelper.*;
import static net.alminoris.aestheticstairs.util.helper.BlockSetsHelper.NSS_WOOD_NAMES;

@Mod(AestheticStairs.MOD_ID)
public class AestheticStairs
{
    public static final String MOD_ID = "aestheticstairs";
    private static final Logger LOGGER = LogUtils.getLogger();

    public AestheticStairs(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents entries)
    {
        if (entries.getTab() == ModItemGroups.ASTAIRS_TAB)
        {
            for(String name : STONES)
                entries.accept(ModBlocks.STAIRCASES.get(name).get());

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_STONES_WF)
                {
                    entries.accept(ModBlocks.STAIRCASES.get(name).get());
                }
            }

            for(String name : STONES)
                entries.accept(ModBlocks.SMALL_STAIRCASES.get(name).get());

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_STONES_WF)
                {
                    entries.accept(ModBlocks.SMALL_STAIRCASES.get(name).get());
                }
            }

            for(String name : STONES)
                entries.accept(ModBlocks.STAIRAILS.get(name).get());

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_STONES_WF)
                {
                    entries.accept(ModBlocks.STAIRAILS.get(name).get());
                }
            }

            for(String name : STONES)
                entries.accept(ModBlocks.SMALL_STAIRAILS.get(name).get());

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_STONES_WF)
                {
                    entries.accept(ModBlocks.SMALL_STAIRAILS.get(name).get());
                }
            }

            for(String name : STONES)
                entries.accept(ModBlocks.SMALL_STAIRS.get(name).get());

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_STONES_WF)
                {
                    entries.accept(ModBlocks.SMALL_STAIRS.get(name).get());
                }
            }

            for(String name : STONES)
                entries.accept(ModBlocks.SMALL_HALFSTAIRS.get(name).get());

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_STONES_WF)
                {
                    entries.accept(ModBlocks.SMALL_HALFSTAIRS.get(name).get());
                }
            }

            for(String name : BlockSetsHelper.WOODS)
                entries.accept(ModBlocks.STAIRCASES.get(name).get());

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : EXTRA_WOODS_AN)
                {
                    entries.accept(ModBlocks.STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_WOODS_WF)
                {
                    entries.accept(ModBlocks.STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : ST_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : WT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : MT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : NSS_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.STAIRCASES.get(name).get());
                }
            }

            for(String name : BlockSetsHelper.WOODS)
                entries.accept(ModBlocks.SMALL_STAIRCASES.get(name).get());

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : EXTRA_WOODS_AN)
                {
                    entries.accept(ModBlocks.SMALL_STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_WOODS_WF)
                {
                    entries.accept(ModBlocks.SMALL_STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : ST_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : WT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : MT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRCASES.get(name).get());
                }
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : NSS_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRCASES.get(name).get());
                }
            }

            for(String name : BlockSetsHelper.WOODS)
                entries.accept(ModBlocks.STAIRAILS.get(name).get());

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : EXTRA_WOODS_AN)
                {
                    entries.accept(ModBlocks.STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_WOODS_WF)
                {
                    entries.accept(ModBlocks.STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : ST_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : WT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : MT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : NSS_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.STAIRAILS.get(name).get());
                }
            }

            for(String name : BlockSetsHelper.WOODS)
                entries.accept(ModBlocks.SMALL_STAIRAILS.get(name).get());

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : EXTRA_WOODS_AN)
                {
                    entries.accept(ModBlocks.SMALL_STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_WOODS_WF)
                {
                    entries.accept(ModBlocks.SMALL_STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : ST_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : WT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : MT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRAILS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : NSS_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRAILS.get(name).get());
                }
            }

            for(String name : BlockSetsHelper.WOODS)
                entries.accept(ModBlocks.SMALL_STAIRS.get(name).get());

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : EXTRA_WOODS_AN)
                {
                    entries.accept(ModBlocks.SMALL_STAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_WOODS_WF)
                {
                    entries.accept(ModBlocks.SMALL_STAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : ST_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : WT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : MT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : NSS_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_STAIRS.get(name).get());
                }
            }

            for(String name : BlockSetsHelper.WOODS)
                entries.accept(ModBlocks.SMALL_HALFSTAIRS.get(name).get());

            if (ModList.get().isLoaded("arborealnature"))
            {
                for(String name : EXTRA_WOODS_AN)
                {
                    entries.accept(ModBlocks.SMALL_HALFSTAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("wildfields"))
            {
                for(String name : EXTRA_WOODS_WF)
                {
                    entries.accept(ModBlocks.SMALL_HALFSTAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("silverwoodtrees"))
            {
                for(String name : ST_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_HALFSTAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("whisperleaftrees"))
            {
                for(String name : WT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_HALFSTAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("missingtrees"))
            {
                for(String name : MT_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_HALFSTAIRS.get(name).get());
                }
            }

            if (ModList.get().isLoaded("natures_spirit"))
            {
                for(String name : NSS_WOOD_NAMES)
                {
                    entries.accept(ModBlocks.SMALL_HALFSTAIRS.get(name).get());
                }
            }
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}