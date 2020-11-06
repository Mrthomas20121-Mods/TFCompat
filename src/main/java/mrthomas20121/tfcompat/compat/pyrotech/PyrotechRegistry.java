package mrthomas20121.tfcompat.compat.pyrotech;

import com.codetaylor.mc.pyrotech.PyrotechAPI;
import com.codetaylor.mc.pyrotech.modules.bucket.ModuleBucket;
import com.codetaylor.mc.pyrotech.modules.core.item.ItemMaterial;
import com.codetaylor.mc.pyrotech.modules.tech.basic.ModuleTechBasic;
import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.AnvilRecipe;
import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.CompactingBinRecipe;
import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.SoakingPotRecipe;
import com.codetaylor.mc.pyrotech.modules.tool.ModuleTool;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Rock;
import net.dries007.tfc.objects.blocks.BlockSlabTFC;
import net.dries007.tfc.objects.blocks.BlocksTFC;
import net.dries007.tfc.objects.blocks.stone.BlockRockVariant;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.ItemsTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.rock.ItemBrickTFC;
import net.dries007.tfc.objects.items.rock.ItemRock;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import tfctech.objects.items.TechItems;

import javax.annotation.Nonnull;
import java.util.ArrayList;

@SuppressWarnings("ConstantConditions")
public class PyrotechRegistry extends RecipeRegistry {

    public PyrotechRegistry()
    {
        super("pyrotech_registry");
    }

    public void init(FMLInitializationEvent event) {
        registerHammers();

        HeatHelper.addItemHeat(ItemMaterial.EnumType.UNFIRED_REFRACTORY_BRICK.asStack(), 600, 580);
        HeatHelper.addItemHeat(new ItemStack(ModuleBucket.Items.BUCKET_CLAY_UNFIRED), 1500, 1700);
        HeatHelper.addItemHeat(new ItemStack(ModuleTool.Items.UNFIRED_CLAY_SHEARS), 1500, 1700);

        HeatHelper.addItemHeat(ItemMaterial.EnumType.REFRACTORY_BRICK.asStack(), 600, 580);
        HeatHelper.addItemHeat(new ItemStack(ModuleBucket.Items.BUCKET_CLAY), 1500, 1700);
        HeatHelper.addItemHeat(new ItemStack(ModuleTool.Items.CLAY_SHEARS), 1500, 1700);
    }

    @Nonnull
    @Override
    public ArrayList<HeatRecipe> addHeatRecipes(ArrayList<HeatRecipe> recipes) {
        recipes.add(new HeatRecipeSimple(IIngredient.of(ItemMaterial.EnumType.UNFIRED_REFRACTORY_BRICK.asStack()), ItemMaterial.EnumType.REFRACTORY_BRICK.asStack(), 480).setRegistryName(new ResourceLocation(TFCompat.MODID, "unfired_refractory_brick")));
        recipes.add(new HeatRecipeSimple(IIngredient.of(ModuleBucket.Items.BUCKET_CLAY_UNFIRED), new ItemStack(ModuleBucket.Items.BUCKET_CLAY, 1), 1500).setRegistryName(new ResourceLocation(TFCompat.MODID, "unfired_clay_bucket")));
        recipes.add(new HeatRecipeSimple(IIngredient.of(ModuleTool.Items.UNFIRED_CLAY_SHEARS), new ItemStack(ModuleTool.Items.CLAY_SHEARS, 1), 1500).setRegistryName(new ResourceLocation(TFCompat.MODID, "unfired_clay_shears")));
        return super.addHeatRecipes(recipes);
    }

    @Nonnull
    @Override
    public ArrayList<KnappingRecipe> addKnappingRecipes(ArrayList<KnappingRecipe> recipes) {
        recipes.add(new KnappingRecipeSimple(KnappingType.CLAY, true, new ItemStack(ModuleBucket.Items.BUCKET_CLAY_UNFIRED), "X   X", "X   X", "X   X", "XX XX", "  X  ").setRegistryName("pyrotech_unfired_clay_bucket"));
        recipes.add(new KnappingRecipeSimple(KnappingType.CLAY, true, new ItemStack(ModuleTool.Items.UNFIRED_CLAY_SHEARS), "XX  X", "X  X ", " XX  ", " XX X", "X  XX").setRegistryName("pyrotech_unfired_clay_shears"));
        return super.addKnappingRecipes(recipes);
    }

    @Nonnull
    @Override
    public ArrayList<IRecipe> addRecipes(ArrayList<IRecipe> recipes) {
        AnvilRecipes(ModuleTechBasic.Registries.ANVIL_RECIPE);
        SoakingPotRecipes(ModuleTechBasic.Registries.SOAKING_POT_RECIPE);
        CompactingBinRecipes(ModuleTechBasic.Registries.COMPACTING_BIN_RECIPE);
        return super.addRecipes(recipes);
    }

    @Nonnull
    @Override
    public ArrayList<ResourceLocation> removeRecipes(ArrayList<ResourceLocation> recipes) {
        recipes.add(new ResourceLocation("pyrotech:bucket/bucket_clay_unfired"));
        recipes.add(new ResourceLocation("pyrotech:tool/unfired_clay_shears"));
        return super.removeRecipes(recipes);
    }

    private void registerHammers() {
        for(Metal metal : TFCRegistries.METALS.getValuesCollection())
        {
            if(metal.isToolMetal() || metal.isArmorMetal()) {
                Item hammer = ItemMetal.get(metal, Metal.ItemType.HAMMER);
                PyrotechAPI.registerHammer(hammer, metal.getToolMetal().getHarvestLevel());
            }
        }
    }

    private void CompactingBinRecipes(IForgeRegistry<CompactingBinRecipe> r)
    {
        // fire clay to clay
        registerBinRecipe(r,"tfc_fire_clay", new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tfc:fire_clay_block")), 1), new ItemStack(ItemsTFC.FIRE_CLAY, 4),4);

        // straw to thatch
        registerBinRecipe(r,"tfc_thatch", new ItemStack(BlocksTFC.THATCH, 1), new ItemStack(ItemsTFC.STRAW, 4), 4);
        for(Rock rock : TFCRegistries.ROCKS.getValuesCollection())
        {
            ItemRock itemRock = ItemRock.get(rock);
            BlockRockVariant gravel = BlockRockVariant.get(rock, Rock.Type.GRAVEL);
            registerBinRecipe(r, "tfc_gravel_"+rock.getRegistryName().getPath(), new ItemStack(gravel, 1), new ItemStack(itemRock, 8),4);
        }

    }

    private void AnvilRecipes(IForgeRegistry<AnvilRecipe> r)
    {
        for(Rock rock : TFCRegistries.ROCKS.getValuesCollection())
        {
            ItemRock itemRock = ItemRock.get(rock);
            BlockRockVariant smooth = BlockRockVariant.get(rock, Rock.Type.SMOOTH);
            BlockRockVariant cobble = BlockRockVariant.get(rock, Rock.Type.COBBLE);
            BlockRockVariant brick = BlockRockVariant.get(rock, Rock.Type.BRICKS);
            BlockSlabTFC.Half cobbleSlab = BlockSlabTFC.Half.get(rock, Rock.Type.COBBLE);
            BlockSlabTFC.Half smoothSlab = BlockSlabTFC.Half.get(rock, Rock.Type.SMOOTH);
            BlockSlabTFC.Half brickSlab = BlockSlabTFC.Half.get(rock, Rock.Type.BRICKS);
            r.register(createAnvilRecipe(
                    "cobble_slab_"+rock.getRegistryName().getPath(),
                    new ItemStack(cobbleSlab, 2),
                    new ItemStack(cobble, 1),
                    8,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.GRANITE)
            );
            r.register(createAnvilRecipe(
                    "ironclad_cobble_slab_"+rock.getRegistryName().getPath(),
                    new ItemStack(cobbleSlab, 2),
                    new ItemStack(cobble, 1),
                    7,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.IRONCLAD)
            );
            r.register(createAnvilRecipe(
                    "smooth_slab_"+rock.getRegistryName().getPath(),
                    new ItemStack(smoothSlab, 2),
                    new ItemStack(smooth, 1),
                    8,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.GRANITE)
            );
            r.register(createAnvilRecipe(
                    "ironclad_smooth_slab_"+rock.getRegistryName().getPath(),
                    new ItemStack(smoothSlab, 2),
                    new ItemStack(smooth, 1),
                    7,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.IRONCLAD)
            );
            r.register(createAnvilRecipe(
                    "brick_slab_"+rock.getRegistryName().getPath(),
                    new ItemStack(brickSlab, 2),
                    new ItemStack(brick, 1),
                    8,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.GRANITE)
            );
            r.register(createAnvilRecipe(
                    "ironclad_brick_slab_"+rock.getRegistryName().getPath(),
                    new ItemStack(brickSlab, 2),
                    new ItemStack(brick, 1),
                    7,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.IRONCLAD)
            );
            r.register(createAnvilRecipe(
                    "refractory_brick_"+rock.getRegistryName().getPath(),
                    ItemMaterial.EnumType.BRICK_STONE.asStack(2),
                    new ItemStack(brickSlab, 2),
                    4,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.GRANITE)
            );
            r.register(createAnvilRecipe(
                    "ironclad_refractory_brick_"+rock.getRegistryName().getPath(),
                    ItemMaterial.EnumType.BRICK_STONE.asStack(2),
                    new ItemStack(brickSlab, 1),
                    4,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.IRONCLAD)
            );

            for(Rock.Type type : Rock.Type.values())
            {
                if(type != Rock.Type.DIRT && type != Rock.Type.ANVIL && type != Rock.Type.DRY_GRASS && type != Rock.Type.FARMLAND && type != Rock.Type.PATH && type != Rock.Type.SAND && type != Rock.Type.GRASS && type != Rock.Type.SPIKE)
                {
                    BlockRockVariant variant = BlockRockVariant.get(rock, type);
                    if(type == Rock.Type.BRICKS)
                    {
                        ItemBrickTFC brickTFC = ItemBrickTFC.get(rock);
                        r.register(createAnvilRecipe(
                                rock.getRegistryName().getPath()+"_from_"+type.name(),
                                new ItemStack(brickTFC, 4),
                                new ItemStack(variant, 1),
                                8,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.GRANITE)
                        );
                        r.register(createAnvilRecipe(
                                "ironclad_"+rock.getRegistryName().getPath()+"_from_"+type.name(),
                                new ItemStack(brickTFC, 5),
                                new ItemStack(variant, 1),
                                7,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.IRONCLAD)
                        );
                    }
                    else if(type == Rock.Type.CLAY || type == Rock.Type.CLAY_GRASS)
                    {
                        ItemBrickTFC brickTFC = ItemBrickTFC.get(rock);
                        r.register(createAnvilRecipe(
                                rock.getRegistryName().getPath()+"_"+type.name(),
                                new ItemStack(Items.CLAY_BALL, 4),
                                new ItemStack(variant, 1),
                                8,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.GRANITE)
                        );
                        r.register(createAnvilRecipe(
                                "ironclad_"+rock.getRegistryName().getPath()+"_"+type.name(),
                                new ItemStack(Items.CLAY_BALL, 4),
                                new ItemStack(variant, 1),
                                7,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.IRONCLAD)
                        );
                    }
                    else
                    {
                        r.register(createAnvilRecipe(
                                rock.getRegistryName().getPath()+"_from_"+type.name(),
                                new ItemStack(itemRock, 6),
                                new ItemStack(variant, 1),
                                8,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.GRANITE)
                        );
                        r.register(createAnvilRecipe(
                                "ironclad_"+rock.getRegistryName().getPath()+"_from_"+type.name(),
                                new ItemStack(itemRock, 6),
                                new ItemStack(variant, 1),
                                8,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.IRONCLAD)
                        );
                    }
                }
            }
        }
        for(Metal metal : TFCRegistries.METALS.getValuesCollection())
        {

            if(checkMetal(metal))
            {
                Item double_ingot = ItemMetal.get(metal, Metal.ItemType.DOUBLE_INGOT);
                Item ingot = ItemMetal.get(metal, Metal.ItemType.INGOT);

                Item double_sheet = ItemMetal.get(metal, Metal.ItemType.DOUBLE_SHEET);
                Item sheet = ItemMetal.get(metal, Metal.ItemType.SHEET);

                r.register(createAnvilRecipe(
                        metal.getRegistryName().getPath()+"_ingot_tfc",
                        new ItemStack(ingot, 2),
                        new ItemStack(double_ingot, 1),
                        8,
                        AnvilRecipe.EnumType.HAMMER,
                        AnvilRecipe.EnumTier.IRONCLAD)
                );
                r.register(createAnvilRecipe(
                        metal.getRegistryName().getPath()+"_sheet_tfc",
                        new ItemStack(sheet, 2),
                        new ItemStack(double_sheet, 1),
                        8,
                        AnvilRecipe.EnumType.HAMMER,
                        AnvilRecipe.EnumTier.IRONCLAD)
                );
            }
        }
    }

    private void SoakingPotRecipes(IForgeRegistryModifiable<SoakingPotRecipe> r)
    {
        r.register(createSoakingPotRecipe(
                "tfc_tech_slaked_lime",
                ItemMaterial.EnumType.SLAKED_LIME.asStack(1),
                Ingredient.fromItem(TechItems.LIME),
                FluidRegistry.getFluidStack("fresh_water", 125),
                false,
                7
        ));

    }
    private static void registerBinRecipe(IForgeRegistry<CompactingBinRecipe> r, String registryName, ItemStack output, ItemStack input, int time)
    {
        CompactingBinRecipe recipe = new CompactingBinRecipe(output, Ingredient.fromStacks(input), time);
        recipe.setRegistryName(registryName);
        r.register(recipe);
    }

    private static AnvilRecipe createAnvilRecipe(String registryName, ItemStack output, ItemStack input, int hit, AnvilRecipe.EnumType type, AnvilRecipe.EnumTier tier)
    {
        AnvilRecipe recipe = new AnvilRecipe(output, Ingredient.fromStacks(input), hit, type, tier);
        recipe.setRegistryName(TFCompat.MODID, registryName);
        return recipe;
    }


    private static SoakingPotRecipe createSoakingPotRecipe(String registryName, ItemStack output, Ingredient inputItem, FluidStack inputFluid, boolean campfire, int timeTicks)
    {
        SoakingPotRecipe recipe = new SoakingPotRecipe(output, inputItem, inputFluid, campfire, timeTicks);
        recipe.setRegistryName(registryName);
        return recipe;
    }

    private static boolean checkMetal(Metal metal)
    {
        String metal_name = metal.getRegistryName().getPath();
        return !(metal == Metal.UNKNOWN || metal_name.contains("high") || metal_name.contains("weak"));
    }
}
