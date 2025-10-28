package net.alminoris.aestheticstairs.item;

import net.alminoris.aestheticstairs.AestheticStairs;
import net.alminoris.aestheticstairs.block.ModBlocks;
import net.alminoris.aestheticstairs.util.helper.BlockSetsHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.aestheticstairs.util.helper.BlockSetsHelper.*;
import static net.alminoris.aestheticstairs.util.helper.BlockSetsHelper.NSS_WOOD_NAMES;

@Mod.EventBusSubscriber(modid = AestheticStairs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AestheticStairs.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ASTAIRS_TAB = CREATIVE_MODE_TABS.register("astairstab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(ModBlocks.STAIRCASES.get("oak").get().asItem()::getDefaultInstance)
            .title(Component.translatable("itemgroup.astairstab"))
            .displayItems((parameters, entries) ->
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
            }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}