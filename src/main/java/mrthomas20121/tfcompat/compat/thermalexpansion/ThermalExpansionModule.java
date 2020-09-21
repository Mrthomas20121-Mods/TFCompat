package mrthomas20121.tfcompat.compat.thermalexpansion;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.tfcompat.library.ModuleCore;
import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.dries007.tfc.api.types.Metal;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ThermalExpansionModule extends ModuleCore {

    private RecipeCore recipes = new ThermalExpansionRecipes();

    public ThermalExpansionModule()
    {
        super("module_thermal", "thermalexapansion");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        MetalUtils.registerMetal("signalum", Metal.Tier.TIER_V, true, 1500, 1300, 0x0);
        MetalUtils.registerMetal("lumium", Metal.Tier.TIER_V, true, 1500, 1300, 0x0);
        MetalUtils.registerMetal("enderium", Metal.Tier.TIER_VI, true, 1500, 1300, 0x0);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        recipes.registerRecipes(null);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {
    }
}
