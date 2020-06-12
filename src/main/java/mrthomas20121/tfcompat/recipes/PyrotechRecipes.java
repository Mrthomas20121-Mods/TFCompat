package mrthomas20121.tfcompat.recipes;

import com.codetaylor.mc.pyrotech.PyrotechAPI;

import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.minecraft.item.Item;

public class PyrotechRecipes extends Recipes
{
    public static void recipes() 
    {
        registerHammers();
    }
    private static void registerHammers() {
        for(Metal metal : TFCRegistries.METALS.getValuesCollection()) 
        {
            if(metal.isToolMetal()) {
                Item hammer = ItemMetal.get(metal, Metal.ItemType.HAMMER);
                PyrotechAPI.registerHammer(hammer, metal.getToolMetal().getHarvestLevel());
            }
        }
        //PyrotechAPI.registerHammer(item, harvestLevel);
    }
}