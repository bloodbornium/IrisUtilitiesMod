package net.irisfarina.irisutilities.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.irisfarina.irisutilities.IrisUtilitiesMod.MODID;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,MODID);

    public static final Supplier<CreativeModeTab> IRIS_UTILITIES_TAB = CREATIVE_MODE_TABS.register(
            "iris_utilities_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.MOONLIGHT_FLOWER.get()))
                    .title(Component.translatable("creativetab.irisutilities.iris_utilities_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.MOONLIGHT_FLOWER);
                    }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
