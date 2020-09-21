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
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class CeramicsModule extends ModuleCore implements IHeatRecipe, IBarrelRecipe, IKnappingRecipe, IRecipeRemoval {

    int colorMax = 15;

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
        for(EnumDyeColor color : EnumDyeColor.values())
        {
            OreDictionary.registerOre("porcelain", new ItemStack(Ceramics.porcelain, 1, color.getMetadata()));
            OreDictionary.registerOre("clayBarrel", new ItemStack(Ceramics.clayBarrelStained, 1, color.getMetadata()));
            OreDictionary.registerOre("clayBarrelExtension", new ItemStack(Ceramics.clayBarrelStainedExtension, 1, color.getMetadata()));
            OreDictionary.registerOre("porcelainBarrelExtension", new ItemStack(Ceramics.porcelainBarrelExtension, 1, color.getMetadata()));
            OreDictionary.registerOre("porcelainBarrel", new ItemStack(Ceramics.porcelainBarrel, 1, color.getMetadata()));
        }
        OreDictionary.registerOre("clayBarrel", new ItemStack(Ceramics.clayBarrel, 1));

        // clay bucket
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1), 2500, 2000);

        // clay plate
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1, 8), 2500, 2000);

        // clay shears
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1, 1), 2500, 2000);
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
        r.register(HeatHelper.addRecipe("ceramics_clay_plate", new ItemStack(Ceramics.clayUnfired, 1, 8), new ItemStack(Ceramics.clayUnfired, 1, 9), 1599));
        r.register(HeatHelper.addRecipe("ceramics_clay_bucket", new ItemStack(Ceramics.clayUnfired, 1), new ItemStack(Ceramics.clayBucket, 1), 1599));
        r.register(HeatHelper.addRecipe("ceramics_clay_shears", new ItemStack(Ceramics.clayUnfired, 1, 1), new ItemStack(Ceramics.clayShears, 1), 1599));
    }

    @Override
    public void initBarrelRecipes(IForgeRegistry<BarrelRecipe> r) {

        for(EnumDyeColor color : EnumDyeColor.values())
        {
            String dyeName = color == EnumDyeColor.SILVER ? "light_gray" : color.getName();
            int meta = color.getMetadata();
            Fluid fluid = FluidsTFC.getFluidFromDye(color).get();

            // porcelaine
            r.register(BarrelHelper.addRecipe(dyeName+"_porcelaine", fluid, 125, "porcelain", new ItemStack(Ceramics.porcelain, 1, meta), 1));
            r.register(BarrelHelper.addRecipe(dyeName+"_porcelaine_barrel", fluid, 125, "porcelainBarrel", new ItemStack(Ceramics.porcelainBarrel, 1, meta), 1));
            r.register(BarrelHelper.addRecipe(dyeName+"_porcelaine_barrel_extension", fluid, 125, "porcelainBarrelExtension", new ItemStack(Ceramics.porcelainBarrelExtension, 1, meta), 1));

            // clay
            r.register(BarrelHelper.addRecipe(dyeName+"_clay_barrel", fluid, 125, "clayBarrel", new ItemStack(Ceramics.clayBarrelStained, 1, meta), 1));
            r.register(BarrelHelper.addRecipe(dyeName+"_clay_barrel_extension", fluid, 125, "clayBarrelExtension", new ItemStack(Ceramics.clayBarrelStainedExtension, 1, meta), 1));

        }
    }

    @Override
    public void initKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        r.register(KnappingHelper.addClayKnapping("ceramics_clay_bucket", false, new ItemStack(Ceramics.clayUnfired, 1, 0), "X   X", "X   X", "X   X", "XX XX", "  X  "));
        r.register(KnappingHelper.addClayKnapping("ceramics_clay_shears", false, new ItemStack(Ceramics.clayUnfired, 1, 1), "XX  X", "X  X ", " XX  ", " XX X", "X  XX"));
        r.register(KnappingHelper.addClayKnapping("ceramics_clay_plate", false, new ItemStack(Ceramics.clayUnfired, 1, 8), " XXX ", "X   X", "X   X", "X   X", " XXX "));
    }
}
