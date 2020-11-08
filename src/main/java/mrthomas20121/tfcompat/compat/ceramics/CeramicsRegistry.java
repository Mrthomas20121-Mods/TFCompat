package mrthomas20121.tfcompat.compat.ceramics;

import knightminer.ceramics.Ceramics;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.knapping.Types;
import mrthomas20121.tfcompat.client.GuiHandler;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.BarrelHelper;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import mrthomas20121.tfcompat.library.helpers.KnappingHelper;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.objects.fluids.FluidsTFC;
import net.dries007.tfc.util.OreDictionaryHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class CeramicsRegistry extends RecipeRegistry {

    public CeramicsRegistry()
    {
        super("ceramics_registry");
    }

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
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBucket, 1), 2500, 2000);

        // clay plate
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1, 8), 2500, 2000);
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1, 9), 2500, 2000);

        // clay shears
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1, 1), 2500, 2000);
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBucket, 1), 2500, 2000);
    }

    @Nonnull
    @Override
    public ArrayList<ResourceLocation> removeRecipes(ArrayList<ResourceLocation> recipes) {
        for(EnumDyeColor color : EnumDyeColor.values())
        {
            String dyeName = color == EnumDyeColor.SILVER ? "light_gray" : color.getName();
            recipes.add(new ResourceLocation("ceramics:barrels/stained_barrel/"+dyeName));
            recipes.add(new ResourceLocation("ceramics:barrels/stained_barrel/"+dyeName+"_alt"));
            recipes.add(new ResourceLocation("ceramics:barrels/porcelain_barrel/"+dyeName));
            recipes.add(new ResourceLocation("ceramics:barrels/porcelain_barrel/"+dyeName+"_alt"));
            recipes.add(new ResourceLocation("ceramics:decoration/porcelain/"+dyeName));
        }
        recipes.add(new ResourceLocation("ceramics:tools/unfired_clay_bucket"));
        recipes.add(new ResourceLocation("ceramics:tools/unfired_clay_shears"));
        recipes.add(new ResourceLocation("ceramics:armor/unfired_clay_plate"));
        recipes.add(new ResourceLocation("ceramics:barrels/unfired_clay_barrel"));
        recipes.add(new ResourceLocation("ceramics:barrels/unfired_clay_barrel_extension"));
        return super.removeRecipes(recipes);
    }

    @Nonnull
    @Override
    public ArrayList<HeatRecipe> addHeatRecipes(ArrayList<HeatRecipe> recipes) {
        recipes.add(HeatHelper.addRecipe("ceramics_clay_plate", new ItemStack(Ceramics.clayUnfired, 1, 8), new ItemStack(Ceramics.clayUnfired, 1, 9), 1599));
        recipes.add(HeatHelper.addRecipe("ceramics_clay_bucket", new ItemStack(Ceramics.clayUnfired, 1), new ItemStack(Ceramics.clayBucket, 1), 1599));
        recipes.add(HeatHelper.addRecipe("ceramics_clay_shears", new ItemStack(Ceramics.clayUnfired, 1, 1), new ItemStack(Ceramics.clayShears, 1), 1599));
        return super.addHeatRecipes(recipes);
    }

    @Nonnull
    @Override
    public ArrayList<BarrelRecipe> addBarrelRecipes(ArrayList<BarrelRecipe> recipes) {
        for(EnumDyeColor color : EnumDyeColor.values())
        {
            String dyeName = color == EnumDyeColor.SILVER ? "light_gray" : color.getName();
            int meta = color.getMetadata();
            Fluid fluid = FluidsTFC.getFluidFromDye(color).get();

            // porcelaine
            recipes.add(BarrelHelper.addRecipe(dyeName+"_porcelaine", fluid, 125, "porcelain", new ItemStack(Ceramics.porcelain, 1, meta), 1));
            recipes.add(BarrelHelper.addRecipe(dyeName+"_porcelaine_barrel", fluid, 125, "porcelainBarrel", new ItemStack(Ceramics.porcelainBarrel, 1, meta), 1));
            recipes.add(BarrelHelper.addRecipe(dyeName+"_porcelaine_barrel_extension", fluid, 125, "porcelainBarrelExtension", new ItemStack(Ceramics.porcelainBarrelExtension, 1, meta), 1));
            // clay
            recipes.add(BarrelHelper.addRecipe(dyeName+"_clay_barrel", fluid, 125, "clayBarrel", new ItemStack(Ceramics.clayBarrelStained, 1, meta), 1));
            recipes.add(BarrelHelper.addRecipe(dyeName+"_clay_barrel_extension", fluid, 125, "clayBarrelExtension", new ItemStack(Ceramics.clayBarrelStainedExtension, 1, meta), 1));
        }
        return super.addBarrelRecipes(recipes);
    }

    @Nonnull
    @Override
    public ArrayList<KnappingRecipe> addKnappingRecipes(ArrayList<KnappingRecipe> recipes) {
        recipes.add(KnappingHelper.addClayKnapping("ceramics_clay_bucket", false, new ItemStack(Ceramics.clayUnfired, 1, 0), "X   X", "X   X", "X   X", "XX XX", "  X  "));
        recipes.add(KnappingHelper.addClayKnapping("ceramics_clay_shears", false, new ItemStack(Ceramics.clayUnfired, 1, 1), "XX  X", "X  X ", " XX  ", " XX X", "X  XX"));
        recipes.add(KnappingHelper.addClayKnapping("ceramics_clay_plate", false, new ItemStack(Ceramics.clayUnfired, 1, 8), " XXX ", "X   X", "X   X", "X   X", " XXX "));
        recipes.add(new KnappingRecipeSimple(Types.PORCELAIN, false, new ItemStack(Ceramics.porcelainBarrel, 1), "X   X", "X   X", "X   X", "X   X", "XXXXX").setRegistryName(TFCompat.MODID, "porcelain_barrel"));

        return super.addKnappingRecipes(recipes);
    }

    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        if(OreDictionaryHelper.doesStackMatchOre(event.getItemStack(), "porcelain"))
        {
            EntityPlayer player = event.getEntityPlayer();
            World world = event.getWorld();
            if (!world.isRemote && !player.isSneaking())
            {
                GuiHandler.openGui(world, player.getPosition(), player, GuiHandler.Type.PORCELAIN);
            }
        }
    }
}
