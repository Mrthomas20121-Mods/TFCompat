package mrthomas20121.tfcompat.compat.iron_backpacks;

import gr8pefish.ironbackpacks.api.IronBackpacksAPI;
import gr8pefish.ironbackpacks.api.backpack.variant.BackpackSpecialty;
import gr8pefish.ironbackpacks.api.backpack.variant.BackpackType;
import gr8pefish.ironbackpacks.api.backpack.variant.BackpackVariant;
import gr8pefish.ironbackpacks.item.ItemBackpack;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.awt.*;

public class IronBackpackRegistry extends RecipeRegistry {

    public IronBackpackRegistry() {
        super("ironbackpacks_registry");
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void registerBackpacks(RegistryEvent.Register<BackpackType> event) {
        IForgeRegistry<BackpackType> r = event.getRegistry();

        for(Metal metal: TFCRegistries.METALS.getValuesCollection()) {
            if(metal.isUsable() && metal.isToolMetal()) {
                int tier = getTier(metal.getTier());
                r.register(new BackpackType(new ResourceLocation(TFCompat.MODID, metal.getRegistryName().getPath()), tier, tier+3, tier>0, 9, tier+1));
            }
        }
    }

    private static int getTier(Metal.Tier tier) {
        if(tier.equals(Metal.Tier.TIER_0) || tier.equals(Metal.Tier.TIER_I)) {
            return 0;
        }
        else if (tier.equals(Metal.Tier.TIER_II) || tier.equals(Metal.Tier.TIER_III)) {
            return 1;
        }
        else if (tier.equals(Metal.Tier.TIER_IV) || tier.equals(Metal.Tier.TIER_V)) {
            return 2;
        }
        else {
            return 3;
        }
    }

}
