package mrthomas20121.tfcompat.compat.pyrotech;

import com.codetaylor.mc.pyrotech.PyrotechAPI;
import com.codetaylor.mc.pyrotech.modules.bucket.ModuleBucket;
import com.codetaylor.mc.pyrotech.modules.core.item.ItemMaterial;
import com.codetaylor.mc.pyrotech.modules.tech.basic.ModuleTechBasic;
import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.AnvilRecipe;
import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.CompactingBinRecipe;
import com.codetaylor.mc.pyrotech.modules.tech.basic.recipe.SoakingPotRecipe;
import com.codetaylor.mc.pyrotech.modules.tech.machine.ModuleTechMachine;
import com.codetaylor.mc.pyrotech.modules.tech.machine.recipe.BrickOvenRecipe;
import com.codetaylor.mc.pyrotech.modules.tech.machine.recipe.StoneOvenRecipe;
import com.codetaylor.mc.pyrotech.modules.tool.ModuleTool;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.client.GuiHandler;
import mrthomas20121.tfcompat.compat.pyrotech.override.TFCBrickOvenRecipe;
import mrthomas20121.tfcompat.compat.pyrotech.override.TFCStoneOvenRecipe;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
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
import net.dries007.tfc.objects.items.food.ItemFoodTFC;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.rock.ItemBrickTFC;
import net.dries007.tfc.objects.items.rock.ItemRock;
import net.dries007.tfc.util.OreDictionaryHelper;
import net.dries007.tfc.util.agriculture.Food;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
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
        if(TFCompatConfig.DefaultConfig.pyrotech.hammer) registerHammers();

        OreDictionary.registerOre("clayFlint", ItemMaterial.EnumType.FLINT_CLAY_BALL.asStack());
        OreDictionary.registerOre("clayRefractory", ItemMaterial.EnumType.REFRACTORY_CLAY_BALL.asStack());

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
        if(TFCompatConfig.DefaultConfig.pyrotech.anvil) AnvilRecipes(ModuleTechBasic.Registries.ANVIL_RECIPE);
        if(TFCompatConfig.DefaultConfig.pyrotech.soaking_pot) SoakingPotRecipes(ModuleTechBasic.Registries.SOAKING_POT_RECIPE);
        if(TFCompatConfig.DefaultConfig.pyrotech.compacting_bin) CompactingBinRecipes(ModuleTechBasic.Registries.COMPACTING_BIN_RECIPE);
        if(TFCompatConfig.DefaultConfig.pyrotech.stone_oven) stoneOvenRecipes(ModuleTechMachine.Registries.STONE_OVEN_RECIPES);
        if(TFCompatConfig.DefaultConfig.pyrotech.brick_oven) brickOvenRecipes(ModuleTechMachine.Registries.BRICK_OVEN_RECIPES);

        return super.addRecipes(recipes);
    }

    @Nonnull
    @Override
    public ArrayList<ResourceLocation> removeRecipes(ArrayList<ResourceLocation> recipes) {
        recipes.add(new ResourceLocation("pyrotech:bucket/bucket_clay_unfired"));
        recipes.add(new ResourceLocation("pyrotech:tool/unfired_clay_shears"));
        recipes.add(new ResourceLocation("pyrotech:refractory_brick_block"));
        recipes.add(new ResourceLocation("pyrotech:refractory_brick_unfired"));
        recipes.add(new ResourceLocation("pyrotech:refractory_clay_ball_from_refractory_clay_lump"));
        return super.removeRecipes(recipes);
    }

    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        EnumHand hand = event.getHand();
        if(OreDictionaryHelper.doesStackMatchOre(event.getItemStack(), "clayFlint") && hand == EnumHand.MAIN_HAND)
        {
            EntityPlayer player = event.getEntityPlayer();
            World world = event.getWorld();
            if (!world.isRemote && !player.isSneaking())
            {
                GuiHandler.openGui(world, player.getPosition(), player, GuiHandler.Type.FLINT_CLAY);
            }
        }
        else if(OreDictionaryHelper.doesStackMatchOre(event.getItemStack(), "clayRefractory") && hand == EnumHand.MAIN_HAND)
        {
            EntityPlayer player = event.getEntityPlayer();
            World world = event.getWorld();
            if (!world.isRemote && !player.isSneaking())
            {
                GuiHandler.openGui(world, player.getPosition(), player, GuiHandler.Type.REFRACTORY_CLAY);
            }
        }
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

    private void SoakingPotRecipes(IForgeRegistry<SoakingPotRecipe> r)
    {
        addSoakingPotRecipe(r, "tech_slaked_lime", ItemMaterial.EnumType.SLAKED_LIME.asStack(1), Ingredient.fromItem(TechItems.LIME),
                FluidRegistry.getFluidStack("fresh_water", 125), false, 7);

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

    private static void addSoakingPotRecipe(IForgeRegistry<SoakingPotRecipe> r, String registryName, ItemStack output, Ingredient inputItem, FluidStack inputFluid, boolean campfire, int timeTicks)
    {
        SoakingPotRecipe recipe = new SoakingPotRecipe(output, inputItem, inputFluid, campfire, timeTicks);
        recipe.setRegistryName(registryName);
        r.register(recipe);
    }

    private static void stoneOvenRecipes(IForgeRegistry<StoneOvenRecipe> r)
    {
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_BEAR)), Ingredient.fromItem(ItemFoodTFC.get(Food.BEAR))).setRegistryName(TFCompat.MODID, "cooked_bear"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_BEEF)), Ingredient.fromItem(ItemFoodTFC.get(Food.BEEF))).setRegistryName(TFCompat.MODID, "cooked_beef"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_CALAMARI)), Ingredient.fromItem(ItemFoodTFC.get(Food.CALAMARI))).setRegistryName(TFCompat.MODID, "cooked_calamari"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_CAMELIDAE)), Ingredient.fromItem(ItemFoodTFC.get(Food.CAMELIDAE))).setRegistryName(TFCompat.MODID, "cooked_camelidae"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_CHICKEN)), Ingredient.fromItem(ItemFoodTFC.get(Food.CHICKEN))).setRegistryName(TFCompat.MODID, "cooked_chicken"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_FISH)), Ingredient.fromItem(ItemFoodTFC.get(Food.FISH))).setRegistryName(TFCompat.MODID, "cooked_fish"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_GRAN_FELINE)), Ingredient.fromItem(ItemFoodTFC.get(Food.GRAN_FELINE))).setRegistryName(TFCompat.MODID, "cooked_grançfeline"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_HORSE_MEAT)), Ingredient.fromItem(ItemFoodTFC.get(Food.HORSE_MEAT))).setRegistryName(TFCompat.MODID, "cooked_horse_meat"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_MONGOOSE)), Ingredient.fromItem(ItemFoodTFC.get(Food.MONGOOSE))).setRegistryName(TFCompat.MODID, "cooked_mongoose"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_MUTTON)), Ingredient.fromItem(ItemFoodTFC.get(Food.MUTTON))).setRegistryName(TFCompat.MODID, "cooked_mutton"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_PHEASANT)), Ingredient.fromItem(ItemFoodTFC.get(Food.PHEASANT))).setRegistryName(TFCompat.MODID, "cooked_pheasant"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_PORK)), Ingredient.fromItem(ItemFoodTFC.get(Food.PORK))).setRegistryName(TFCompat.MODID, "cooked_pork"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_RABBIT)), Ingredient.fromItem(ItemFoodTFC.get(Food.RABBIT))).setRegistryName(TFCompat.MODID, "cooked_rabbit"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_VENISON)), Ingredient.fromItem(ItemFoodTFC.get(Food.VENISON))).setRegistryName(TFCompat.MODID, "cooked_venison"));
        r.register(new TFCStoneOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_WOLF)), Ingredient.fromItem(ItemFoodTFC.get(Food.WOLF))).setRegistryName(TFCompat.MODID, "cooked_wolf"));
    }

    private static void brickOvenRecipes(IForgeRegistry<BrickOvenRecipe> r)
    {
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_BEAR)), Ingredient.fromItem(ItemFoodTFC.get(Food.BEAR))).setRegistryName(TFCompat.MODID, "cooked_bear"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_BEEF)), Ingredient.fromItem(ItemFoodTFC.get(Food.BEEF))).setRegistryName(TFCompat.MODID, "cooked_beef"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_CALAMARI)), Ingredient.fromItem(ItemFoodTFC.get(Food.CALAMARI))).setRegistryName(TFCompat.MODID, "cooked_calamari"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_CAMELIDAE)), Ingredient.fromItem(ItemFoodTFC.get(Food.CAMELIDAE))).setRegistryName(TFCompat.MODID, "cooked_camelidae"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_CHICKEN)), Ingredient.fromItem(ItemFoodTFC.get(Food.CHICKEN))).setRegistryName(TFCompat.MODID, "cooked_chicken"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_FISH)), Ingredient.fromItem(ItemFoodTFC.get(Food.FISH))).setRegistryName(TFCompat.MODID, "cooked_fish"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_GRAN_FELINE)), Ingredient.fromItem(ItemFoodTFC.get(Food.GRAN_FELINE))).setRegistryName(TFCompat.MODID, "cooked_grançfeline"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_HORSE_MEAT)), Ingredient.fromItem(ItemFoodTFC.get(Food.HORSE_MEAT))).setRegistryName(TFCompat.MODID, "cooked_horse_meat"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_MONGOOSE)), Ingredient.fromItem(ItemFoodTFC.get(Food.MONGOOSE))).setRegistryName(TFCompat.MODID, "cooked_mongoose"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_MUTTON)), Ingredient.fromItem(ItemFoodTFC.get(Food.MUTTON))).setRegistryName(TFCompat.MODID, "cooked_mutton"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_PHEASANT)), Ingredient.fromItem(ItemFoodTFC.get(Food.PHEASANT))).setRegistryName(TFCompat.MODID, "cooked_pheasant"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_PORK)), Ingredient.fromItem(ItemFoodTFC.get(Food.PORK))).setRegistryName(TFCompat.MODID, "cooked_pork"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_RABBIT)), Ingredient.fromItem(ItemFoodTFC.get(Food.RABBIT))).setRegistryName(TFCompat.MODID, "cooked_rabbit"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_VENISON)), Ingredient.fromItem(ItemFoodTFC.get(Food.VENISON))).setRegistryName(TFCompat.MODID, "cooked_venison"));
        r.register(new TFCBrickOvenRecipe(new ItemStack(ItemFoodTFC.get(Food.COOKED_WOLF)), Ingredient.fromItem(ItemFoodTFC.get(Food.WOLF))).setRegistryName(TFCompat.MODID, "cooked_wolf"));

    }

    private static boolean checkMetal(Metal metal)
    {
        return ObfuscationReflectionHelper.getPrivateValue(Metal.class, metal, "usable").equals(true);
    }
}
