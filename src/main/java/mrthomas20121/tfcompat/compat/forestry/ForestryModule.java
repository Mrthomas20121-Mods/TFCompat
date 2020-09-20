package mrthomas20121.tfcompat.compat.forestry;

import mrthomas20121.tfcompat.library.ModuleCore;
import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ForestryModule extends ModuleCore {

    private RecipeCore recipes = new ForestryRecipes();

    public ForestryModule()
    {
        super("module_forestry", "forestry");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        // FuelManager.addFuel(new Fuel(IIngredient.of("dustCarbon"), 1, 100));
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {
        recipes.registerRecipes(r);
    }
}
