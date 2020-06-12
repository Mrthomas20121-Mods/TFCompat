package mrthomas20121.tfcompat;

import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import mrthomas20121.tfcompat.recipes.MekanismRecipes;
import mrthomas20121.tfcompat.recipes.PyrotechRecipes;

@Mod.EventBusSubscriber(modid = TFCompat.MODID)
public class Registry 
{
	@SubscribeEvent
    public static void onRegisterRecipesEvent(RegistryEvent.Register<IRecipe> event) {
        if(isModLoaded("mekanism")) 
        {
            MekanismRecipes.recipes();
        }
        if(isModLoaded("pyrotech")) 
        {
            PyrotechRecipes.init();
        }
    }
    private static boolean isModLoaded(String mod)
    {
        return Loader.isModLoaded(mod);
    }
}