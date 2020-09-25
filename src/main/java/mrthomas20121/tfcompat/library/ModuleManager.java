package mrthomas20121.tfcompat.library;

import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.compat.actuallyadditions.ActuallyAdditionsModule;
import mrthomas20121.tfcompat.compat.betterwithmods.BetterWithModsModule;
import mrthomas20121.tfcompat.compat.ceramics.CeramicsModule;
import mrthomas20121.tfcompat.compat.forestry.ForestryModule;
import mrthomas20121.tfcompat.compat.improvedbackpacks.ImprovedBackpacksModule;
import mrthomas20121.tfcompat.compat.mekanism.MekanismModule;
import mrthomas20121.tfcompat.compat.pyrotech.PyrotechModule;
import mrthomas20121.tfcompat.compat.thaumcraft.ThaumcraftModule;
import mrthomas20121.tfcompat.compat.thermalexpansion.ThermalExpansionModule;
import mrthomas20121.tfcompat.library.recipes.IBarrelRecipe;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import mrthomas20121.tfcompat.library.recipes.IKnappingRecipe;
import mrthomas20121.tfcompat.library.recipes.IRecipeRemoval;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = TFCompat.MODID)
public class ModuleManager
{

    private static ArrayList<ModuleCore> modules = new ArrayList<>();

    public static void registerModule(ModuleCore module)
    {
        if(isLoaded(module.getDep()))
        {
            modules.add(module);
        }
    }

    public static ArrayList<ModuleCore> getModules() {
        return modules;
    }

    public static void initModules()
    {
        registerModule(new ActuallyAdditionsModule());
        registerModule(new BetterWithModsModule());
        registerModule(new CeramicsModule());
        registerModule(new ForestryModule());
        registerModule(new ImprovedBackpacksModule());
        registerModule(new MekanismModule());
        registerModule(new PyrotechModule());
        registerModule(new ThaumcraftModule());
        registerModule(new ThermalExpansionModule());
    }

    @SubscribeEvent
    public static void onRegisterRecipesEvent(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> r = event.getRegistry();

        for(ModuleCore module : modules)
        {
                module.initRecipes(r);
                if(module instanceof IRecipeRemoval)
                {
                    ((IRecipeRemoval)module).removal(r);
                }
        }
    }

    @SubscribeEvent
    public static void onRegisterHeatRecipeEvent(RegistryEvent.Register<HeatRecipe> event)
    {
        for(ModuleCore module : modules)
        {
            if(module instanceof IHeatRecipe)
            {
                ((IHeatRecipe) module).initHeatRecipes(event.getRegistry());
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterKnappingRecipeEvent(RegistryEvent.Register<KnappingRecipe> event)
    {
        IForgeRegistry<KnappingRecipe> r = event.getRegistry();
        for(ModuleCore module : modules)
        {
            if(module instanceof IKnappingRecipe)
            {
                ((IKnappingRecipe) module).initKnappingRecipes(event.getRegistry());
            }
        }
    }

    @SubscribeEvent
    public static void onRegisterBarrelRecipeEvent(RegistryEvent.Register<BarrelRecipe> event)
    {
        IForgeRegistry<BarrelRecipe> r = event.getRegistry();
        for(ModuleCore module : modules)
        {
            if(module instanceof IBarrelRecipe)
            {
                ((IBarrelRecipe) module).initBarrelRecipes(event.getRegistry());
            }
        }
    }

    private static boolean isLoaded(String modName)
    {
        return Loader.isModLoaded(modName);
    }
}
