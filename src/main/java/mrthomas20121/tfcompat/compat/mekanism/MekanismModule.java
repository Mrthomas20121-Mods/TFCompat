package mrthomas20121.tfcompat.compat.mekanism;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.rocksalt.utils.OredictUtils;
import mrthomas20121.tfcompat.library.ModuleCore;
import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.util.Helpers;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class MekanismModule extends ModuleCore {

    private RecipeCore recipes = Helpers.getNull();

    public MekanismModule()
    {
        super("module_mekanism", "mekanism");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        recipes = new MekanismRecipes();

        MetalUtils.registerMetal("refined_obsidian", Metal.Tier.TIER_VI, true, 1500, 1300, 0x0);
        MetalUtils.registerMetal("refined_glowstone", Metal.Tier.TIER_VI, true, 1500, 1300, 0x0);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        OredictUtils.add("refined_glowstone", "glowstone");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {
        recipes.registerRecipes(r);
    }
}
