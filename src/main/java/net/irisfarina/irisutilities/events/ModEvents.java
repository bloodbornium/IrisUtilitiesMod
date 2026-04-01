package net.irisfarina.irisutilities.events;


import net.irisfarina.irisutilities.IrisUtilitiesMod;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ClientboundSetCarriedItemPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import org.joml.Random;


public class ModEvents {
    public static int isRandomizeOn = 0;
    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            if (isRandomizeOn == 0) {
                return;
            }
            Random random = new Random();
            int slot = 8 - random.nextInt(isRandomizeOn + 1);
            System.out.println(slot);
            player.getInventory().selected = slot;


            player.connection.send(new ClientboundSetCarriedItemPacket(slot));



        }

    }
    public static void onRandomizeSwitch(InputEvent.Key event) {

        if (event.getKey() == 329 && event.getAction() == 1) {
            Minecraft mc = Minecraft.getInstance();
            if (isRandomizeOn < 4) {
                isRandomizeOn += 1;
                mc.getChatListener().handleSystemMessage(Component.literal(String.format("Randomizacja: %d bloków",isRandomizeOn+1)),true);
            } else {
                isRandomizeOn = 0;
                mc.getChatListener().handleSystemMessage(Component.literal("Brak randomizacji"),true);
            }


        }
    }

}
