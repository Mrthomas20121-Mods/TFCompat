package mrthomas20121.tfcompat.compat.thermalexpansion;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.tfcompat.compat.ArmorMaterialsTFCompat;
import mrthomas20121.tfcompat.compat.ToolMaterialsTFCompat;
import mrthomas20121.tfcompat.library.ModuleCore;
import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.util.Helpers;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ThermalExpansionModule extends ModuleCore {

    private RecipeCore recipes = Helpers.getNull();

    public ThermalExpansionModule()
    {
        super("module_thermal", "thermalexpansion");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        recipes = new ThermalExpansionRecipes();
        MetalUtils.registerMetal("signalum", Metal.Tier.TIER_V, true, 1500, 1300, 0xA13800, ToolMaterialsTFCompat.signalum, ArmorMaterialsTFCompat.signalum);
        MetalUtils.registerMetal("lumium", Metal.Tier.TIER_V, true, 1500, 1300, 0xFFE46A, ToolMaterialsTFCompat.lumium, ArmorMaterialsTFCompat.lumium);
        MetalUtils.registerMetal("enderium", Metal.Tier.TIER_VI, true, 1500, 1300, 0x0E6A6A, ToolMaterialsTFCompat.enderium, ArmorMaterialsTFCompat.enderium);
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {
        recipes.registerRecipes(r);
    }
}
