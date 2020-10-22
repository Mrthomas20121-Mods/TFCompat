package mrthomas20121.tfcompat.compat.tech_reborn;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.tfcompat.library.ModuleCore;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.util.Helpers;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TechRebornModule extends ModuleCore implements IHeatRecipe {

    public static Metal refined_iron;

    private TechRebornRecipes techRebornRecipes = Helpers.getNull();

    public TechRebornModule()
    {
        super("module_tech_reborn", "techreborn");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        techRebornRecipes = new TechRebornRecipes();

        refined_iron = MetalUtils.registerMetal("refined_iron", Metal.Tier.TIER_IV, true, 3000, 1900, 0x0);
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {
        techRebornRecipes.registerRecipes(r);
    }

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        techRebornRecipes.initHeatRecipes(r);
    }
}
