package net.alminoris.aestheticstairs.item;

import net.alminoris.aestheticstairs.AestheticStairs;
import net.alminoris.aestheticstairs.block.ModBlocks;
import net.alminoris.aestheticstairs.util.helper.BlockSetsHelper;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static net.alminoris.aestheticstairs.util.helper.BlockSetsHelper.*;
import static net.alminoris.aestheticstairs.util.helper.BlockSetsHelper.NSS_WOOD_NAMES;

@Mod.EventBusSubscriber(modid = AestheticStairs.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItemGroups
{
    public static CreativeModeTab ASTAIRS_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
    {
        ASTAIRS_TAB = event.registerCreativeModeTab(ResourceLocation.fromNamespaceAndPath(AestheticStairs.MOD_ID, "astairstab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.STAIRCASES.get("oak").get().asItem()))
                        .title(Component.translatable("itemgroup.astairstab")));
    }
}