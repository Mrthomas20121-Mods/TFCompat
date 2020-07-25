package mrthomas20121.tfcompat;

import mrthomas20121.tfcompat.recipes.*;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

@Mod.EventBusSubscriber(modid = TFCompat.MODID)
public class Registry 
{
    public static void init()
    {
        if(isModLoaded("pyrotech"))
        {
            PyrotechRecipes.initHeating();
        }
        if(isModLoaded("improvedbackpacks"))
        {
            ImprovedBackpacksRecipes.initHeating();
        }
    }

	@SubscribeEvent
    public static void onRegisterRecipesEvent(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> r = event.getRegistry();
        if(isModLoaded("mekanism")) 
        {
            MekanismRecipes.recipes();
        }
        if(isModLoaded("pyrotech")) 
        {
            PyrotechRecipes.init();
            ((IForgeRegistryModifiable<IRecipe>) r).remove(new ResourceLocation("pyrotech:bucket/bucket_clay_unfired"));
            ((IForgeRegistryModifiable<IRecipe>) r).remove(new ResourceLocation("pyrotech:tool/unfired_clay_shears"));
        }
        if(isModLoaded("betterwithmods"))
        {
            BWMRecipes.init();
            ((IForgeRegistryModifiable<IRecipe>) r).remove(new ResourceLocation("tfc:gunpowder"));
            ((IForgeRegistryModifiable<IRecipe>) r).remove(new ResourceLocation("tfc:gunpowder_graphite"));
        }
        if(isModLoaded("thermalexpansion"))
        {
            ThermalRecipes.init();
        }
    }

    @SubscribeEvent
    public static void onRegisterHeatRecipeEvent(RegistryEvent.Register<HeatRecipe> event)
    {
        IForgeRegistry<HeatRecipe> r = event.getRegistry();
        if(isModLoaded("pyrotech"))
        {
            PyrotechRecipes.HeatRecipes(r);
        }
        if(isModLoaded("improvedbackpacks"))
        {
            ImprovedBackpacksRecipes.HeatRecipes(r);
        }
    }

    @SubscribeEvent
    public static void onRegisterKnappingRecipeEvent(RegistryEvent.Register<KnappingRecipe> event)
    {
        IForgeRegistry<KnappingRecipe> r = event.getRegistry();
        if(isModLoaded("pyrotech"))
		{
			PyrotechRecipes.pyrotechKnappingRecipes(r);
		}

    }

    private static boolean isModLoaded(String mod)
    {
        return Loader.isModLoaded(mod);
    }
}