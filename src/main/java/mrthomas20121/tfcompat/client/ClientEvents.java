package mrthomas20121.tfcompat.client;

import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.api.capability.metal.IMetalItem;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.awt.*;
import java.util.ArrayList;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = TFCompat.MODID)
public class ClientEvents {

    public static ArrayList<Item> colorItems = new ArrayList<>();

    @SubscribeEvent
    public static void registerItemColourHandlers(final ColorHandlerEvent.Item event)
    {
        final ItemColors itemColors = event.getItemColors();

        for(Item item: colorItems) {
            itemColors.registerItemColorHandler(
                    (stack, tintIndex) -> {
                        return (new Color(((IMetalItem) stack.getItem()).getMetal(stack).getColor())).brighter().getRGB();
                    },item
            );
        }
    }
}
