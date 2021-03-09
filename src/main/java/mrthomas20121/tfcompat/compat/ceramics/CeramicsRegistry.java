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
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

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
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBucket, 1), 1.0F, 1599.0F);

        // clay plate
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1, 8), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1, 9), 1.0F, 1599.0F);

        // clay shears
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayUnfired, 1, 1), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBucket, 1), 1.0F, 1599.0F);
    }

    @Override
    public void removeRecipes(IForgeRegistryModifiable<IRecipe> r) {
        for(EnumDyeColor color : EnumDyeColor.values())
        {
            String dyeName = color == EnumDyeColor.SILVER ? "light_gray" : color.getName();
            r.remove(new ResourceLocation("ceramics:barrels/stained_barrel/"+dyeName));
            r.remove(new ResourceLocation("ceramics:barrels/stained_barrel/"+dyeName+"_alt"));
            r.remove(new ResourceLocation("ceramics:barrels/porcelain_barrel/"+dyeName));
            r.remove(new ResourceLocation("ceramics:barrels/porcelain_barrel/"+dyeName+"_alt"));
            r.remove(new ResourceLocation("ceramics:decoration/porcelain/"+dyeName));
        }
        r.remove(new ResourceLocation("ceramics:tools/unfired_clay_bucket"));
        r.remove(new ResourceLocation("ceramics:tools/unfired_clay_shears"));
        r.remove(new ResourceLocation("ceramics:armor/unfired_clay_plate"));
        r.remove(new ResourceLocation("ceramics:barrels/unfired_clay_barrel"));
        r.remove(new ResourceLocation("ceramics:barrels/unfired_clay_barrel_extension"));
        r.remove(new ResourceLocation("ceramics:barrels/unfired_porcelain_barrel"));
        r.remove(new ResourceLocation("ceramics:barrels/unfired_porcelain_extension"));
        r.remove(new ResourceLocation("ceramics:faucet"));
        r.remove(new ResourceLocation("ceramics:channel"));
    }

    @Override
    public void registerHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        r.registerAll(
                HeatHelper.addRecipe("ceramics_clay_plate", new ItemStack(Ceramics.clayUnfired, 1, 8), new ItemStack(Ceramics.clayUnfired, 1, 9), 1599),
                HeatHelper.addRecipe("ceramics_clay_bucket", new ItemStack(Ceramics.clayUnfired, 1), new ItemStack(Ceramics.clayBucket, 1), 1599),
                HeatHelper.addRecipe("ceramics_clay_shears", new ItemStack(Ceramics.clayUnfired, 1, 1), new ItemStack(Ceramics.clayShears, 1), 1599),
                HeatHelper.addRecipe("ceramics_porcelain_barrel", new ItemStack(Ceramics.clayBarrelUnfired, 1, 2), new ItemStack(Ceramics.porcelainBarrel, 1), 1599)
        );
    }

    @Override
    public void registerBarrelRecipes(IForgeRegistry<BarrelRecipe> r) {
        for(EnumDyeColor color : EnumDyeColor.values())
        {
            String dyeName = color == EnumDyeColor.SILVER ? "light_gray" : color.getName();
            int meta = color.getMetadata();
            Fluid fluid = FluidsTFC.getFluidFromDye(color).get();

            r.registerAll(
                    // porcelaine
                    BarrelHelper.addRecipe(dyeName+"_porcelaine", fluid, 125, "porcelain", new ItemStack(Ceramics.porcelain, 1, meta), 1),
                    BarrelHelper.addRecipe(dyeName+"_porcelaine_barrel", fluid, 125, "porcelainBarrel", new ItemStack(Ceramics.porcelainBarrel, 1, meta), 1),
                    BarrelHelper.addRecipe(dyeName+"_porcelaine_barrel_extension", fluid, 125, "porcelainBarrelExtension", new ItemStack(Ceramics.porcelainBarrelExtension, 1, meta), 1),
                    // clay
                    BarrelHelper.addRecipe(dyeName+"_clay_barrel", fluid, 125, "clayBarrel", new ItemStack(Ceramics.clayBarrelStained, 1, meta), 1),
                    BarrelHelper.addRecipe(dyeName+"_clay_barrel_extension", fluid, 125, "clayBarrelExtension", new ItemStack(Ceramics.clayBarrelStainedExtension, 1, meta), 1)
            );
        }
    }

    @Override
    public void registerKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        r.registerAll(
                KnappingHelper.addClayKnapping("ceramics_clay_bucket", false, new ItemStack(Ceramics.clayUnfired, 1, 0), "X   X", "X   X", "X   X", "XX XX", "  X  "),
                KnappingHelper.addClayKnapping("ceramics_clay_shears", false, new ItemStack(Ceramics.clayUnfired, 1, 1), "XX  X", "X  X ", " XX  ", " XX X", "X  XX"),
                KnappingHelper.addClayKnapping("ceramics_clay_plate", false, new ItemStack(Ceramics.clayUnfired, 1, 8), " XXX ", "X   X", "X   X", "X   X", " XXX "),
                // porcelain knapping
                new KnappingRecipeSimple(Types.PORCELAIN, false, new ItemStack(Ceramics.clayBarrelUnfired, 1, 2), "X   X", "X   X", "X   X", "X   X", "XXXXX").setRegistryName(TFCompat.MODID, "unfired_porcelain_barrel"),
                new KnappingRecipeSimple(Types.PORCELAIN, false, new ItemStack(Ceramics.clayUnfired, 1, 6), " X X ", "  X  ").setRegistryName(TFCompat.MODID, "unfired_faucet"),
                new KnappingRecipeSimple(Types.PORCELAIN, false, new ItemStack(Ceramics.clayUnfired, 1, 7), " X X ", " XXX ").setRegistryName(TFCompat.MODID, "unfired_channel")
        );

    }

    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        if(OreDictionaryHelper.doesStackMatchOre(event.getItemStack(), "clayPorcelain"))
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
