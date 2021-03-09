package mrthomas20121.tfcompat.compat.crafttweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import mrthomas20121.tfcompat.TFCompat;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.tfcompat.knapping")
public class CTKnapping {

    @ZenMethod
    public static void add(String type, String name, IItemStack output, String... pattern) {
        KnappingType knappingType = CTKnappingHelper.getType(type);
        if(knappingType != null) {
            CTKnappingHelper.addRecipe(new ResourceLocation(TFCompat.MODID, name), knappingType, output, pattern);
        }
        else {
            CraftTweakerAPI.logError("Error Wrong Type name entered!");
        }
    }

    @ZenMethod
    public static void remove(String type, IItemStack output) {
        KnappingType knappingType = CTKnappingHelper.getType(type);
        if(knappingType != null) {
            CTKnappingHelper.removeRecipe(output, knappingType);
        }
        else CraftTweakerAPI.logError("Error Wrong Type name entered!");
    }

    @ZenMethod
    public static void remove(String registryName) {
        CTKnappingHelper.removeRecipe(registryName);
    }
}
