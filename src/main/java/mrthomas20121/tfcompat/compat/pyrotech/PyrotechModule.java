package mrthomas20121.tfcompat.compat.pyrotech;

import com.codetaylor.mc.pyrotech.PyrotechAPI;
import com.codetaylor.mc.pyrotech.modules.bucket.ModuleBucket;
import com.codetaylor.mc.pyrotech.modules.core.item.ItemMaterial;
import com.codetaylor.mc.pyrotech.modules.tool.ModuleTool;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import mrthomas20121.tfcompat.library.recipes.IKnappingRecipe;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingType;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class PyrotechModule extends ModuleCore implements IHeatRecipe, IKnappingRecipe {

    public PyrotechModule()
    {
        super("module_pyrotech", "pyrotech");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        registerHammers();

        HeatHelper.addItemHeat(ItemMaterial.EnumType.UNFIRED_REFRACTORY_BRICK.asStack(), 600, 580);
        HeatHelper.addItemHeat(new ItemStack(ModuleBucket.Items.BUCKET_CLAY_UNFIRED), 1500, 1700);
        HeatHelper.addItemHeat(new ItemStack(ModuleTool.Items.UNFIRED_CLAY_SHEARS), 1500, 1700);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {

    }

    private void registerHammers() {
        for(Metal metal : TFCRegistries.METALS.getValuesCollection())
        {
            if(metal.isToolMetal()) {
                Item hammer = ItemMetal.get(metal, Metal.ItemType.HAMMER);
                PyrotechAPI.registerHammer(hammer, metal.getToolMetal().getHarvestLevel());
            }
        }
    }

    @Override
    public void initHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        r.register(new HeatRecipeSimple(IIngredient.of(ItemMaterial.EnumType.UNFIRED_REFRACTORY_BRICK.asStack()), ItemMaterial.EnumType.REFRACTORY_BRICK.asStack(), 480).setRegistryName(new ResourceLocation(TFCompat.MODID, "unfired_refractory_brick")));
        r.register(new HeatRecipeSimple(IIngredient.of(ModuleBucket.Items.BUCKET_CLAY_UNFIRED), new ItemStack(ModuleBucket.Items.BUCKET_CLAY, 1), 1500).setRegistryName(new ResourceLocation(TFCompat.MODID, "unfired_clay_bucket")));
        r.register(new HeatRecipeSimple(IIngredient.of(ModuleTool.Items.UNFIRED_CLAY_SHEARS), new ItemStack(ModuleTool.Items.CLAY_SHEARS, 1), 1500).setRegistryName(new ResourceLocation(TFCompat.MODID, "unfired_clay_shears")));
    }

    @Override
    public void initKnappingRecipes(IForgeRegistry<KnappingRecipe> r) {
        r.register(new KnappingRecipeSimple(KnappingType.CLAY, true, new ItemStack(ModuleBucket.Items.BUCKET_CLAY_UNFIRED), "X   X", "X   X", "X   X", "XX XX", "  X  ").setRegistryName("pyrotech_unfired_clay_bucket"));
        r.register(new KnappingRecipeSimple(KnappingType.CLAY, true, new ItemStack(ModuleTool.Items.UNFIRED_CLAY_SHEARS), "XX  X", "X  X ", " XX  ", " XX X", "X  XX").setRegistryName("pyrotech_unfired_clay_shears"));
    }
}
