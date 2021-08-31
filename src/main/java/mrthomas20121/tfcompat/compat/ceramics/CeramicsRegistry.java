package mrthomas20121.tfcompat.compat.ceramics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

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

public class CeramicsRegistry extends RecipeRegistry {

    public CeramicsRegistry() {
        super("ceramics_registry");
    }

    public void init(FMLInitializationEvent event) {
        for(EnumDyeColor color : EnumDyeColor.values())
        {
            OreDictionary.registerOre("clayBarrel", new ItemStack(Ceramics.clayBarrelStained, 1, color.getMetadata()));
            OreDictionary.registerOre("clayBarrelExtension", new ItemStack(Ceramics.clayBarrelStainedExtension, 1, color.getMetadata()));
            OreDictionary.registerOre("porcelain", new ItemStack(Ceramics.porcelain, 1, color.getMetadata()));
            OreDictionary.registerOre("porcelainBarrel", new ItemStack(Ceramics.porcelainBarrel, 1, color.getMetadata()));
            OreDictionary.registerOre("porcelainBarrelExtension", new ItemStack(Ceramics.porcelainBarrelExtension, 1, color.getMetadata()));
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
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayShears, 1), 1.0F, 1599.0F);
        // clay barrel
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBarrelUnfired, 1), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBarrel, 1), 1.0F, 1599.0F);
        // clay barrel extension
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBarrelUnfired, 1, 1), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBarrel, 1, 1), 1.0F, 1599.0F);
        // porcelain barrel
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBarrelUnfired, 1, 2), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(Ceramics.porcelainBarrel, 1), 1.0F, 1599.0F);
        // porcelain barrel extension
        HeatHelper.addItemHeat(new ItemStack(Ceramics.clayBarrelUnfired, 1, 3), 1.0F, 1599.0F);
        HeatHelper.addItemHeat(new ItemStack(Ceramics.porcelainBarrelExtension, 1), 1.0F, 1599.0F);
    }

    @Override
    public void removeRecipes(IForgeRegistryModifiable<IRecipe> r) {
        for(EnumDyeColor color : EnumDyeColor.values())
        {
            String dyeName = color.getName();
            r.remove(new ResourceLocation("ceramics:barrels/stained_barrel/"+dyeName));
            r.remove(new ResourceLocation("ceramics:barrels/stained_barrel/"+dyeName+"_alt"));
            r.remove(new ResourceLocation("ceramics:barrels/stained_barrel/stained_"+dyeName));
            r.remove(new ResourceLocation("ceramics:barrels/stained_barrel/stained_"+dyeName+"_alt"));
            r.remove(new ResourceLocation("ceramics:barrels/stained_extension/"+dyeName));
            r.remove(new ResourceLocation("ceramics:barrels/stained_extension/"+dyeName+"_alt"));
            r.remove(new ResourceLocation("ceramics:barrels/porcelain_barrel/"+dyeName));
            r.remove(new ResourceLocation("ceramics:barrels/porcelain_barrel/"+dyeName+"_alt"));
            r.remove(new ResourceLocation("ceramics:barrels/porcelain_extension/"+dyeName));
            r.remove(new ResourceLocation("ceramics:barrels/porcelain_extension/"+dyeName+"_alt"));
            r.remove(new ResourceLocation("ceramics:decoration/porcelain/"+dyeName));
        }
        r.remove(new ResourceLocation("ceramics:tools/unfired_clay_bucket"));
        r.remove(new ResourceLocation("ceramics:tools/unfired_clay_bucket_block"));
        r.remove(new ResourceLocation("ceramics:tools/unfired_clay_shears"));
        r.remove(new ResourceLocation("ceramics:armor/unfired_clay_plate"));
        r.remove(new ResourceLocation("ceramics:barrels/unfired_clay_barrel"));
        r.remove(new ResourceLocation("ceramics:barrels/unfired_clay_extension"));
        r.remove(new ResourceLocation("ceramics:barrels/unfired_porcelain_barrel"));
        r.remove(new ResourceLocation("ceramics:barrels/unfired_porcelain_extension"));
        r.remove(new ResourceLocation("ceramics:faucet"));
        r.remove(new ResourceLocation("ceramics:channel"));
    }

    @Override
    public void registerHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        r.registerAll(
            // clay heating
            HeatHelper.addRecipe("ceramics_clay_bucket", new ItemStack(Ceramics.clayUnfired, 1), new ItemStack(Ceramics.clayBucket, 1), 1599),
            HeatHelper.addRecipe("ceramics_clay_bucket_block", new ItemStack(Ceramics.clayBucketBlock, 1), new ItemStack(Ceramics.clayBucket, 1), 1599),
            HeatHelper.addRecipe("ceramics_clay_plate", new ItemStack(Ceramics.clayUnfired, 1, 8), new ItemStack(Ceramics.clayUnfired, 1, 9), 1599),
            HeatHelper.addRecipe("ceramics_clay_shears", new ItemStack(Ceramics.clayUnfired, 1, 1), new ItemStack(Ceramics.clayShears, 1), 1599),
            HeatHelper.addRecipe("ceramics_clay_barrel", new ItemStack(Ceramics.clayBarrelUnfired, 1), new ItemStack(Ceramics.clayBarrel, 1), 1599),
            HeatHelper.addRecipe("ceramics_clay_barrel_extension", new ItemStack(Ceramics.clayBarrelUnfired, 1, 1), new ItemStack(Ceramics.clayBarrel, 1, 1), 1599),
            // porcelain heating
            HeatHelper.addRecipe("ceramics_porcelain_brick", new ItemStack(Ceramics.clayUnfired, 1, 4), new ItemStack(Ceramics.clayUnfired, 1, 5), 1599),
            HeatHelper.addRecipe("ceramics_porcelain_block", new ItemStack(Ceramics.claySoft, 1), new ItemStack(Ceramics.porcelain, 1), 1599),
            HeatHelper.addRecipe("ceramics_porcelain_barrel", new ItemStack(Ceramics.clayBarrelUnfired, 1, 2), new ItemStack(Ceramics.porcelainBarrel, 1), 1599),
            HeatHelper.addRecipe("ceramics_porcelain_barrel_extension", new ItemStack(Ceramics.clayBarrelUnfired, 1, 3), new ItemStack(Ceramics.porcelainBarrelExtension, 1), 1599),
            HeatHelper.addRecipe("ceramics_faucet", new ItemStack(Ceramics.clayUnfired, 1, 6), new ItemStack(Ceramics.faucet, 1), 1599),
            HeatHelper.addRecipe("ceramics_channel", new ItemStack(Ceramics.clayUnfired, 1, 7), new ItemStack(Ceramics.channel, 1), 1599),
            // dark brick heating
            HeatHelper.addRecipe("ceramics_dark_bricks_block", new ItemStack(Blocks.BRICK_BLOCK, 1), new ItemStack(Ceramics.clayHard, 1, 1), 1599),
            HeatHelper.addRecipe("ceramics_dark_bricks_wall", new ItemStack(Ceramics.clayWall, 1), new ItemStack(Ceramics.clayWall, 1, 2), 1599),
            HeatHelper.addRecipe("ceramics_dark_bricks_slab", new ItemStack(Blocks.STONE_SLAB, 1, 4), new ItemStack(Ceramics.claySlab, 1, 1), 1599),
            HeatHelper.addRecipe("ceramics_dark_bricks_stairs", new ItemStack(Blocks.BRICK_STAIRS, 1), new ItemStack(Ceramics.stairsDarkBricks, 1), 1599)
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
                // porcelain
                BarrelHelper.addRecipe(dyeName+"_porcelain", fluid, 125, "porcelain", new ItemStack(Ceramics.porcelain, 1, meta), 1),
                BarrelHelper.addRecipe(dyeName+"_porcelain_barrel", fluid, 125, "porcelainBarrel", new ItemStack(Ceramics.porcelainBarrel, 1, meta), 1),
                BarrelHelper.addRecipe(dyeName+"_porcelain_barrel_extension", fluid, 125, "porcelainBarrelExtension", new ItemStack(Ceramics.porcelainBarrelExtension, 1, meta), 1),
                // clay
                BarrelHelper.addRecipe(dyeName+"_clay_barrel", fluid, 125, "clayBarrel", new ItemStack(Ceramics.clayBarrelStained, 1, meta), 1),
                BarrelHelper.addRecipe(dyeName+"_clay_barrel_extension", fluid, 125, "clayBarrelExtension", new ItemStack(Ceramics.clayBarrelStainedExtension, 1, meta), 1)
            );
        }
    }

    @Override
    public void registerKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        r.registerAll(
            // clay knapping
            KnappingHelper.addClayKnapping("unfired_clay_bucket", false, new ItemStack(Ceramics.clayUnfired, 1), "X   X", "X   X", "X   X", "XX XX", "  X  "),
            KnappingHelper.addClayKnapping("unfired_clay_bucket_block", false, new ItemStack(Ceramics.clayBucketBlock, 1), "X   X", "X   X", "X   X", "XX XX", "  X  "),
            KnappingHelper.addClayKnapping("unfired_clay_plate", false, new ItemStack(Ceramics.clayUnfired, 1, 8), "     ", " XXX ", " XXX ", " XXX ", "     "),
            KnappingHelper.addClayKnapping("unfired_clay_shears", false, new ItemStack(Ceramics.clayUnfired, 1, 1), "  XX ", " XX X", "X  XX", "X  X ", " XX  "),
            KnappingHelper.addClayKnapping("unfired_clay_barrel", false, new ItemStack(Ceramics.clayBarrelUnfired, 1), "X   X", "X   X", "X   X", "XXXXX", "XXXXX"),
            KnappingHelper.addClayKnapping("unfired_clay_barrel_extension", false, new ItemStack(Ceramics.clayBarrelUnfired, 1, 1), "X   X", "X   X", "X   X", "X   X", "X   X"),
            // porcelain knapping
            new KnappingRecipeSimple(Types.PORCELAIN, false, new ItemStack(Ceramics.clayBarrelUnfired, 1, 2), "X   X", "X   X", "X   X", "XXXXX", "XXXXX").setRegistryName(TFCompat.MOD_ID, "unfired_porcelain_barrel"),
            new KnappingRecipeSimple(Types.PORCELAIN, false, new ItemStack(Ceramics.clayBarrelUnfired, 1, 3), "X   X", "X   X", "X   X", "X   X", "X   X").setRegistryName(TFCompat.MOD_ID, "unfired_porcelain_barrel_extension"),
            new KnappingRecipeSimple(Types.PORCELAIN, false, new ItemStack(Ceramics.clayUnfired, 1, 6), " X X ", "  X  ").setRegistryName(TFCompat.MOD_ID, "unfired_faucet"),
            new KnappingRecipeSimple(Types.PORCELAIN, false, new ItemStack(Ceramics.clayUnfired, 1, 7), " X X ", " XXX ").setRegistryName(TFCompat.MOD_ID, "unfired_channel")
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