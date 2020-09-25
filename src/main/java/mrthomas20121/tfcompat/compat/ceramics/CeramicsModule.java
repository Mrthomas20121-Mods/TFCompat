package mrthomas20121.tfcompat.compat.ceramics;

import knightminer.ceramics.Ceramics;
import mrthomas20121.tfcompat.library.ModuleCore;
import mrthomas20121.tfcompat.library.helpers.BarrelHelper;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import mrthomas20121.tfcompat.library.helpers.KnappingHelper;
import mrthomas20121.tfcompat.library.recipes.IBarrelRecipe;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import mrthomas20121.tfcompat.library.recipes.IKnappingRecipe;
import mrthomas20121.tfcompat.library.recipes.IRecipeRemoval;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.dries007.tfc.objects.fluids.FluidsTFC;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class CeramicsModule extends ModuleCore implements IHeatRecipe, IBarrelRecipe, IKnappingRecipe, IRecipeRemoval {

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
        CeramicsRegistry.instance.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {
    }

    @Override
    public void removal(IForgeRegistry<IRecipe> r) {
        IForgeRegistryModifiable<IRecipe> registry = (IForgeRegistryModifiable<IRecipe>)r;
        for(EnumDyeColor color : EnumDyeColor.values())
        {
            String dyeName = color == EnumDyeColor.SILVER ? "light_gray" : color.getName();
            registry.remove(new ResourceLocation("ceramics:barrels/stained_barrel/"+dyeName));
            registry.remove(new ResourceLocation("ceramics:barrels/stained_barrel/"+dyeName+"_alt"));
            registry.remove(new ResourceLocation("ceramics:barrels/porcelain_barrel/"+dyeName));
            registry.remove(new ResourceLocation("ceramics:barrels/porcelain_barrel/"+dyeName+"_alt"));
            registry.remove(new ResourceLocation("ceramics:decoration/porcelain/"+dyeName));
        }
        registry.remove(new ResourceLocation("ceramics:tools/unfired_clay_bucket"));
        registry.remove(new ResourceLocation("ceramics:tools/unfired_clay_shears"));
        registry.remove(new ResourceLocation("ceramics:armor/unfired_clay_plate"));
        registry.remove(new ResourceLocation("ceramics:barrels/unfired_clay_barrel"));
        registry.remove(new ResourceLocation("ceramics:barrels/unfired_clay_barrel_extension"));
    }

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        CeramicsRegistry.instance.initHeatRecipes(r);
    }

    @Override
    public void initBarrelRecipes(IForgeRegistry<BarrelRecipe> r) {
        CeramicsRegistry.instance.initBarrelRecipes(r);
    }

    @Override
    public void initKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        CeramicsRegistry.instance.initKnappingRecipes(r);
    }
}
