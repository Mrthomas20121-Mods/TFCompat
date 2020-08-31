package mrthomas20121.tfcompat;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.rocksalt.utils.OredictUtils;
import mrthomas20121.tfcompat.recipes.*;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.util.Helpers;
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
    public static Metal soulforge_steel = Helpers.getNull();
    public static Metal signalum = Helpers.getNull();
    public static Metal lumium = Helpers.getNull();
    public static Metal enderium = Helpers.getNull();
    public static Metal refined_obsidian = Helpers.getNull();
    public static Metal refined_glowstone = Helpers.getNull();
    public static Metal thaumium = Helpers.getNull();
    public static Metal voidMetal = Helpers.getNull();
    public static Metal starmetal = Helpers.getNull();

    public static void preInit()
    {
        if(isModLoaded("betterwithmods"))
        {
            soulforge_steel = MetalUtils.registerMetal("soulforge_steel", Metal.Tier.TIER_IV, true, 1500, 1300, 0x0);
        }
        if(isModLoaded("thermalexpansion"))
        {
            signalum = MetalUtils.registerMetal("signalum", Metal.Tier.TIER_V, true, 1500, 1300, 0x0);
            lumium = MetalUtils.registerMetal("lumium", Metal.Tier.TIER_V, true, 1500, 1300, 0x0);
            enderium = MetalUtils.registerMetal("enderium", Metal.Tier.TIER_VI, true, 1500, 1300, 0x0);
        }
        if(isModLoaded("mekanism"))
        {
            refined_obsidian = MetalUtils.registerMetal("refined_obsidian", Metal.Tier.TIER_VI, true, 1500, 1300, 0x0);
            refined_glowstone = MetalUtils.registerMetal("refined_glowstone", Metal.Tier.TIER_VI, true, 1500, 1300, 0x0);
        }
        if(isModLoaded("thaumcraft"))
        {
            thaumium = MetalUtils.registerMetal("thaumium", Metal.Tier.TIER_VI, true, 1500, 1300, 0x0);
            voidMetal = MetalUtils.registerMetal("void_metal", Metal.Tier.TIER_VI, true, 1500, 1300, 0x0);
        }
    }

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
        if(isModLoaded("thaumcraft"))
        {
            OredictUtils.add(voidMetal, "void");
        }
        if(isModLoaded("mekanism"))
        {
            OredictUtils.add(refined_glowstone, "glowstone");
        }
    }
    public static void postInit()
    {
        if(Loader.isModLoaded("thermalexpansion"))
        {
            ThermalRecipes.postInit();
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
    public static void onRegisterBarrelRecipeEvent(RegistryEvent.Register<BarrelRecipe> event)
    {
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