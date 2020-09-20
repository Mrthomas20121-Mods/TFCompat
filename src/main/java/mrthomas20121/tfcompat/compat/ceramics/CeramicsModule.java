package mrthomas20121.tfcompat.compat.ceramics;

import mrthomas20121.tfcompat.library.ModuleCore;
import mrthomas20121.tfcompat.library.recipes.IBarrelRecipe;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import mrthomas20121.tfcompat.library.recipes.IKnappingRecipe;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class CeramicsModule extends ModuleCore implements IHeatRecipe, IBarrelRecipe, IKnappingRecipe {

    KnappingType porcelaine = new KnappingType(2, true);

    public CeramicsModule()
    {
        super("module_ceramics", "ceramics");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {

    }

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {

    }

    @Override
    public void initBarrelRecipes(IForgeRegistry<BarrelRecipe> r) {

    }

    @Override
    public void initKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {

    }
}
