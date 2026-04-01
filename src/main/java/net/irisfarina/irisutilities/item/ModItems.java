package net.irisfarina.irisutilities.item;

import net.irisfarina.irisutilities.IrisUtilitiesMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.irisfarina.irisutilities.IrisUtilitiesMod.MODID;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

//    public static final DeferredItem<Item> MOONLIGHT_FLOWER = ITEMS.register("moonlight_flower",
//            () -> new Item(new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
