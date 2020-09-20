package mrthomas20121.tfcompat.compat.actuallyadditions;

import mrthomas20121.rocksalt.utils.OreUtils;
import mrthomas20121.rocksalt.utils.VeinLoader;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.library.ModuleCore;
import mrthomas20121.tfcompat.library.recipes.RecipeCore;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ActuallyAdditionsModule extends ModuleCore {

    private RecipeCore recipeModule = new ActuallyAdditionsRecipes();

    public ActuallyAdditionsModule()
    {
        super("module_aa", "actuallyadditions");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        OreUtils.registerOre("blackquartz", false, 5d, 5d);
        VeinLoader.preInit(TFCompat.MODID, event.getModConfigurationDirectory(), "tfcompat_aa_ores.json");
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {
        recipeModule.registerRecipes(r);
    }
}
