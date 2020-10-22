package mrthomas20121.tfcompat.compat.pyrotech;

import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import mrthomas20121.tfcompat.library.recipes.IKnappingRecipe;
import mrthomas20121.tfcompat.library.ModuleCore;
import mrthomas20121.tfcompat.library.recipes.IRecipeRemoval;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.util.Helpers;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class PyrotechModule extends ModuleCore implements IHeatRecipe, IKnappingRecipe, IRecipeRemoval {

    private PyrotechRecipes recipes = Helpers.getNull();

    public PyrotechModule()
    {
        super("module_pyrotech", "pyrotech");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        recipes = new PyrotechRecipes();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        recipes.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {
        recipes.registerRecipes(r);
    }

    @Override
    public void removal(IForgeRegistry<IRecipe> r) {
        IForgeRegistryModifiable<IRecipe> registry = (IForgeRegistryModifiable<IRecipe>)r;

        registry.remove(new ResourceLocation("pyrotech:tool/unfired_clay_shears"));
        registry.remove(new ResourceLocation("pyrotech:bucket/bucket_clay_unfired"));
    }

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        recipes.initHeatRecipes(r);
    }

    @Override
    public void initKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        recipes.initKnappingRecipes(r);
    }
}
