package mrthomas20121.tfcompat.library.helpers;

import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class MetalHelper {

    @Nonnull
    public static Item getMetalItem(ResourceLocation metal_name, Metal.ItemType itemType) {
        Metal metal = TFCRegistries.METALS.getValue(metal_name);
        if(metal == null) {
            metal = Metal.UNKNOWN;
        }
        return ItemMetal.get(metal, itemType);
    }

    @Nonnull
    public static ItemStack getMetalItem(ResourceLocation metal_name, Metal.ItemType itemType, int size) {
        return new ItemStack(getMetalItem(metal_name, itemType), size);
    }
}
