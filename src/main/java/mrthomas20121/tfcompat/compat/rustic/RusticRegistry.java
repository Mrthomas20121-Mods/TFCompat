package mrthomas20121.tfcompat.compat.rustic;

import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.dries007.tfc.api.capability.food.CapabilityFood;
import net.dries007.tfc.api.capability.food.FoodData;
import net.dries007.tfc.api.capability.food.FoodHandler;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import rustic.common.blocks.BlockBase;
import rustic.common.blocks.BlockChair;
import rustic.common.blocks.BlockTable;
import rustic.common.items.ModItems;

import java.util.ArrayList;

public class RusticRegistry extends RecipeRegistry {

    public static ArrayList<BlockBase> rusticBlocks = new ArrayList<>();

    public RusticRegistry()
    {
        super("rustic_registry");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.WILDBERRIES)), () -> new FoodHandler(null, new FoodData(4, 0.2F, 0.3F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.IRONBERRIES)), () -> new FoodHandler(null, new FoodData(5, 0.2F, 0.4F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.GRAPES)), () -> new FoodHandler(null, new FoodData(8, 0.0F, 0.5F, 0.0F, 1F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.CHILI_PEPPER)), () -> new FoodHandler(null, new FoodData(6, 0.0F, 0.4F, 0.0F, 0F, 0.9F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.OLIVES)), () -> new FoodHandler(null, new FoodData(4, 0.3F, 0.5F, 0.0F, 1F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.TOMATO)), () -> new FoodHandler(null, new FoodData(4, 0.3F, 0.5F, 0.0F, 1F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.GRAPES)), () -> new FoodHandler(null, new FoodData(4, 0.3F, 0.5F, 0.0F, 1F, 0.0F, 0.0F, 0.0F, 1.0F)));
    }

    @Override
    public void registerBlocks(IForgeRegistry<Block> r)
    {
        for(Tree tree: TFCRegistries.TREES.getValuesCollection())
        {
            BlockChair chair = new BlockChair(tree.getRegistryName().getPath());
            BlockTable table = new BlockTable(tree.getRegistryName().getPath());
            r.registerAll(chair, table);
            rusticBlocks.add(chair);
            rusticBlocks.add(table);
        }
    }

    @Override
    public void registerModels(ModelRegistryEvent event)
    {
        for(BlockBase blockBase : RusticRegistry.rusticBlocks)
        {
            blockBase.initModel();
        }
    }
}
