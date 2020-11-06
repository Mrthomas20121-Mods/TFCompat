package mrthomas20121.tfcompat.library;

import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.compat.actuallyadditions.AAModule;
import mrthomas20121.tfcompat.compat.betterwithmods.BWMModule;
import mrthomas20121.tfcompat.compat.ceramics.CeramicsModule;
import mrthomas20121.tfcompat.compat.forestry.ForestryModule;
import mrthomas20121.tfcompat.compat.improvedbackpacks.BackpacksModule;
import mrthomas20121.tfcompat.compat.mekanism.MekanismModule;
import mrthomas20121.tfcompat.compat.pyrotech.PyrotechModule;
import mrthomas20121.tfcompat.compat.tech_reborn.TechRebornModule;
import mrthomas20121.tfcompat.compat.thaumcraft.ThaumcraftModule;
import mrthomas20121.tfcompat.compat.thermalexpansion.ThermalModule;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

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
        registerModule(new AAModule());
        registerModule(new BWMModule());
        registerModule(new CeramicsModule());
        registerModule(new ForestryModule());
        registerModule(new BackpacksModule());
        registerModule(new MekanismModule());
        registerModule(new PyrotechModule());
        registerModule(new ThaumcraftModule());
        registerModule(new ThermalModule());
        registerModule(new TechRebornModule());
    }

    @SubscribeEvent
    public static void onRegisterRecipesEvent(RegistryEvent.Register<IRecipe> event) {
        IForgeRegistry<IRecipe> r = event.getRegistry();
        IForgeRegistryModifiable<IRecipe> rec = (IForgeRegistryModifiable<IRecipe>)r;

        ArrayList<IRecipe> recipes = new ArrayList<>();
        ArrayList<ResourceLocation> removal = new ArrayList<>();

        for(ModuleCore module : modules)
        {
               if(module.getRegistry() != null)
               {
                   recipes = module.getRegistry().addRecipes(recipes);
                   removal = module.getRegistry().removeRecipes(removal);
               }
        }
        recipes.forEach(recipe -> r.register(recipe));
        removal.forEach(resourceLocation -> rec.remove(resourceLocation));
    }

    @SubscribeEvent
    public static void onRegisterHeatRecipeEvent(RegistryEvent.Register<HeatRecipe> event)
    {
        IForgeRegistry<HeatRecipe> r = event.getRegistry();

        ArrayList<HeatRecipe> heatRecipes = new ArrayList<>();

        for(ModuleCore module : modules)
        {
            if(module.getRegistry() != null)
            {
                heatRecipes = module.getRegistry().addHeatRecipes(heatRecipes);
            }
        }
        heatRecipes.forEach(recipe -> r.register(recipe));
    }

    @SubscribeEvent
    public static void onRegisterKnappingRecipeEvent(RegistryEvent.Register<KnappingRecipe> event)
    {
        IForgeRegistry<KnappingRecipe> r = event.getRegistry();

        ArrayList<KnappingRecipe> knappingRecipes = new ArrayList<>();
        for(ModuleCore module : modules)
        {
            if(module.getRegistry() != null)
            {
                knappingRecipes = module.getRegistry().addKnappingRecipes(knappingRecipes);
            }
        }

        knappingRecipes.forEach(recipe -> r.register(recipe));
    }

    @SubscribeEvent
    public static void onRegisterBarrelRecipeEvent(RegistryEvent.Register<BarrelRecipe> event)
    {
        IForgeRegistry<BarrelRecipe> r = event.getRegistry();

        ArrayList<BarrelRecipe> barrelRecipes = new ArrayList<>();
        for(ModuleCore module : modules)
        {
            if(module.getRegistry() != null)
            {
                barrelRecipes = module.getRegistry().addBarrelRecipes(barrelRecipes);
            }
        }

        barrelRecipes.forEach(recipe -> r.register(recipe));
    }

    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event)
    {
        for(ModuleCore module : modules)
        {
            if(module.getRegistry() != null)
            {
                module.getRegistry().onRightClick(event);
            }
        }
    }

    private static boolean isLoaded(String modName)
    {
        return Loader.isModLoaded(modName);
    }
}
