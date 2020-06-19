package mrthomas20121.tfcompat.recipes;

import com.codetaylor.mc.pyrotech.PyrotechAPI;
import com.codetaylor.mc.pyrotech.modules.bucket.ModuleBucket;
import com.codetaylor.mc.pyrotech.modules.core.ModuleCore;
import com.codetaylor.mc.pyrotech.modules.core.item.ItemMaterial;
import com.codetaylor.mc.pyrotech.modules.tech.basic.ModuleTechBasic;
import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.AnvilRecipe;

import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.CompactingBinRecipe;
import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.SoakingPotRecipe;
import com.codetaylor.mc.pyrotech.modules.tool.ModuleTool;
import net.dries007.tfc.api.capability.heat.CapabilityItemHeat;
import net.dries007.tfc.api.capability.heat.ItemHeatHandler;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.api.types.Rock;
import net.dries007.tfc.objects.blocks.BlockFireClay;
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
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import net.minecraft.item.crafting.Ingredient;

import mrthomas20121.tfcompat.TFCompat;
import tfctech.objects.items.TechItems;

public class PyrotechRecipes extends Recipes
{
    public static void init()
    {
        registerHammers();
        AnvilRecipes(ModuleTechBasic.Registries.ANVIL_RECIPE);
        SoakingPotRecipes(ModuleTechBasic.Registries.SOAKING_POT_RECIPE);
        CompactingBinRecipes(ModuleTechBasic.Registries.COMPACTING_BIN_RECIPE);
    }
    public static void HeatRecipes(IForgeRegistry<HeatRecipe> r)
    {
        r.register(new HeatRecipeSimple(IIngredient.of(ItemMaterial.EnumType.UNFIRED_REFRACTORY_BRICK.asStack()), ItemMaterial.EnumType.REFRACTORY_BRICK.asStack(), 480).setRegistryName(new ResourceLocation(TFCompat.MODID, "unfired_refractory_brick")));
        r.register(new HeatRecipeSimple(IIngredient.of(ModuleBucket.Items.BUCKET_CLAY_UNFIRED), getStack(ModuleBucket.Items.BUCKET_CLAY, 1), 1500).setRegistryName(new ResourceLocation(TFCompat.MODID, "unfired_clay_bucket")));
        r.register(new HeatRecipeSimple(IIngredient.of(ModuleTool.Items.UNFIRED_CLAY_SHEARS), getStack(ModuleTool.Items.CLAY_SHEARS, 1), 1500).setRegistryName(new ResourceLocation(TFCompat.MODID, "unfired_clay_shears")));
    }
    public static void initHeating()
    {
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(ItemMaterial.EnumType.UNFIRED_REFRACTORY_BRICK.asStack()), () -> new ItemHeatHandler(null, 600, 580));
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(ModuleBucket.Items.BUCKET_CLAY_UNFIRED), () -> new ItemHeatHandler(null, 1500, 1700));
        CapabilityItemHeat.CUSTOM_ITEMS.put(IIngredient.of(ModuleTool.Items.UNFIRED_CLAY_SHEARS), () -> new ItemHeatHandler(null, 1500, 1700));
    }
    public static void pyrotechKnappingRecipes(IForgeRegistry<KnappingRecipe> r)
    {
        r.register(new KnappingRecipeSimple(KnappingType.CLAY, true, new ItemStack(ModuleBucket.Items.BUCKET_CLAY_UNFIRED), "X   X", "X   X", "X   X", "XX XX", "  X  ").setRegistryName("pyrotech_unfired_clay_bucket"));
        r.register(new KnappingRecipeSimple(KnappingType.CLAY, true, new ItemStack(ModuleTool.Items.UNFIRED_CLAY_SHEARS), "XX  X", "X  X ", " XX  ", " XX X", "X  XX").setRegistryName("pyrotech_unfired_clay_shears"));
    }

    private static void registerHammers() {
        for(Metal metal : TFCRegistries.METALS.getValuesCollection()) 
        {
            if(metal.isToolMetal()) {
                Item hammer = ItemMetal.get(metal, Metal.ItemType.HAMMER);
                PyrotechAPI.registerHammer(hammer, metal.getToolMetal().getHarvestLevel());
            }
        }
    }

    private static void CompactingBinRecipes(IForgeRegistryModifiable<CompactingBinRecipe> r)
    {
        r.register(createBinRecipe(
                "tfc_fire_clay",
                getStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation("tfc:fire_clay_block")), 1),
                getStack(ItemsTFC.FIRE_CLAY, 4),
                4
                )
        );
        r.register(createBinRecipe(
                "tfc_thatch",
                getStack(BlocksTFC.THATCH, 1),
                getStack(ItemsTFC.STRAW, 4),
                4
                )
        );
        for(Rock rock : TFCRegistries.ROCKS.getValuesCollection())
        {
            ItemRock itemRock = ItemRock.get(rock);
            BlockRockVariant gravel = BlockRockVariant.get(rock, Rock.Type.GRAVEL);
            r.register(createBinRecipe(
                    "tfc_"+rock.getRegistryName().getPath()+"_"+Rock.Type.GRAVEL.name(),
                    getStack(gravel, 1),
                    getStack(itemRock, 8),
                    4
                    )
            );
        }

    }

    private static void AnvilRecipes(IForgeRegistryModifiable<AnvilRecipe> r)
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
                    getStack(cobbleSlab, 2),
                    getStack(cobble, 1),
                    8,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.GRANITE)
            );
            r.register(createAnvilRecipe(
                    "ironclad_cobble_slab_"+rock.getRegistryName().getPath(),
                    getStack(cobbleSlab, 2),
                    getStack(cobble, 1),
                    7,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.IRONCLAD)
            );
            r.register(createAnvilRecipe(
                    "smooth_slab_"+rock.getRegistryName().getPath(),
                    getStack(smoothSlab, 2),
                    getStack(smooth, 1),
                    8,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.GRANITE)
            );
            r.register(createAnvilRecipe(
                    "ironclad_smooth_slab_"+rock.getRegistryName().getPath(),
                    getStack(smoothSlab, 2),
                    getStack(smooth, 1),
                    7,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.IRONCLAD)
            );
            r.register(createAnvilRecipe(
                    "brick_slab_"+rock.getRegistryName().getPath(),
                    getStack(brickSlab, 2),
                    getStack(brick, 1),
                    8,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.GRANITE)
            );
            r.register(createAnvilRecipe(
                    "ironclad_brick_slab_"+rock.getRegistryName().getPath(),
                    getStack(brickSlab, 2),
                    getStack(brick, 1),
                    7,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.IRONCLAD)
            );
            r.register(createAnvilRecipe(
                    "refractory_brick_"+rock.getRegistryName().getPath(),
                    ItemMaterial.EnumType.BRICK_STONE.asStack(2),
                    getStack(brickSlab, 2),
                    4,
                    AnvilRecipe.EnumType.PICKAXE,
                    AnvilRecipe.EnumTier.GRANITE)
            );
            r.register(createAnvilRecipe(
                    "ironclad_refractory_brick_"+rock.getRegistryName().getPath(),
                    ItemMaterial.EnumType.BRICK_STONE.asStack(2),
                    getStack(brickSlab, 1),
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
                                getStack(brickTFC, 4),
                                getStack(variant, 1),
                                8,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.GRANITE)
                        );
                        r.register(createAnvilRecipe(
                                "ironclad_"+rock.getRegistryName().getPath()+"_from_"+type.name(),
                                getStack(brickTFC, 5),
                                getStack(variant, 1),
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
                                getStack(Items.CLAY_BALL, 4),
                                getStack(variant, 1),
                                8,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.GRANITE)
                        );
                        r.register(createAnvilRecipe(
                                "ironclad_"+rock.getRegistryName().getPath()+"_"+type.name(),
                                getStack(Items.CLAY_BALL, 4),
                                getStack(variant, 1),
                                7,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.IRONCLAD)
                        );
                    }
                    else
                    {
                        r.register(createAnvilRecipe(
                                rock.getRegistryName().getPath()+"_from_"+type.name(),
                                getStack(itemRock, 6),
                                getStack(variant, 1),
                                8,
                                AnvilRecipe.EnumType.HAMMER,
                                AnvilRecipe.EnumTier.GRANITE)
                        );
                        r.register(createAnvilRecipe(
                                "ironclad_"+rock.getRegistryName().getPath()+"_from_"+type.name(),
                                getStack(itemRock, 6),
                                getStack(variant, 1),
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

            if(!checkMetal(metal))
            {
                Item double_ingot = ItemMetal.get(metal, Metal.ItemType.DOUBLE_INGOT);
                Item ingot = ItemMetal.get(metal, Metal.ItemType.INGOT);

                Item double_sheet = ItemMetal.get(metal, Metal.ItemType.DOUBLE_SHEET);
                Item sheet = ItemMetal.get(metal, Metal.ItemType.SHEET);

                r.register(createAnvilRecipe(
                        metal.getRegistryName().getPath()+"_ingot_tfc",
                        getStack(ingot, 2),
                        getStack(double_ingot, 1),
                        8,
                        AnvilRecipe.EnumType.HAMMER,
                        AnvilRecipe.EnumTier.IRONCLAD)
                );
                r.register(createAnvilRecipe(
                        metal.getRegistryName().getPath()+"_sheet_tfc",
                        getStack(sheet, 2),
                        getStack(double_sheet, 1),
                        8,
                        AnvilRecipe.EnumType.HAMMER,
                        AnvilRecipe.EnumTier.IRONCLAD)
                );
            }
        }
    }
    private static void SoakingPotRecipes(IForgeRegistryModifiable<SoakingPotRecipe> r)
    {
        r.register(createSoakingPotRecipe(
                "tfc_tech_slaked_lime",
                ItemMaterial.EnumType.SLAKED_LIME.asStack(1),
                Ingredient.fromItem(TechItems.LIME),
                getFluid("fresh_water", 125),
                7
        ));

    }
    private static CompactingBinRecipe createBinRecipe(String registryName, ItemStack output, ItemStack input, int time)
    {
        CompactingBinRecipe recipe = new CompactingBinRecipe(output, Ingredient.fromStacks(input), time);
        recipe.setRegistryName(registryName);
        return recipe;
    }
    private static AnvilRecipe createAnvilRecipe(String registryName, ItemStack output, ItemStack input, int hit, AnvilRecipe.EnumType type, AnvilRecipe.EnumTier tier)
    {
        AnvilRecipe recipe = new AnvilRecipe(output, Ingredient.fromStacks(input), hit, type, tier);
        recipe.setRegistryName(TFCompat.MODID, registryName);
        return recipe;
    }
    private static SoakingPotRecipe createSoakingPotRecipe(String registryName, ItemStack output, Ingredient inputItem, FluidStack inputFluid, int timeTicks)
    {
        SoakingPotRecipe recipe = new SoakingPotRecipe(output, inputItem, inputFluid, timeTicks);
        recipe.setRegistryName(registryName);
        return recipe;
    }
    private static boolean checkMetal(Metal metal)
    {
        String metal_name = metal.getRegistryName().getPath();
        String[] metalsExtrusion = { "unknown", "high_carbon_steel", "high_carbon_red_steel", "high_carbon_blue_steel", "high_carbon_black_steel", "weak_steel", "weak_blue_steel", "weak_red_steel", "weak_black_steel" };
        boolean res = false;
        for(String m : metalsExtrusion)
        {
            if(metal_name.contains(m))
            {
                res = true;
                break;
            }
        }
        return res;
    }
}