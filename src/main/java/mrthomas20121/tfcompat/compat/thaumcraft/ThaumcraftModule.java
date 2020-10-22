package mrthomas20121.tfcompat.compat.thaumcraft;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.rocksalt.utils.OredictUtils;
import mrthomas20121.tfcompat.compat.ArmorMaterialsTFCompat;
import mrthomas20121.tfcompat.compat.ToolMaterialsTFCompat;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.types.Metal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ThaumcraftModule extends ModuleCore implements IHeatRecipe {

    public ThaumcraftModule()
    {
        super("module_thaumcraft","thaumcraft");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        MetalUtils.registerMetal("thaumium", Metal.Tier.TIER_IV, true, 1500, 1300, 0x5A4B8B, ToolMaterialsTFCompat.thaumium, ArmorMaterialsTFCompat.thaumium);
        MetalUtils.registerMetal("void_metal", Metal.Tier.TIER_VI, true, 1500, 1300, 0x2D1847);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        OredictUtils.add("void_metal", "void");
        HeatHelper.addItemHeat("gemCinnabar", 600, 600);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {

    }

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        ThaumcraftRecipes.instance.initHeatRecipes(r);
    }
}
