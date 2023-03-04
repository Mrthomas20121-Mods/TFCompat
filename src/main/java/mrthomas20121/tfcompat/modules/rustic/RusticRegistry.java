package mrthomas20121.tfcompat.modules.rustic;

import mrthomas20121.tfcompat.api.module.ModuleRegistry;
import net.dries007.tfc.api.capability.food.CapabilityFood;
import net.dries007.tfc.api.capability.food.FoodData;
import net.dries007.tfc.api.capability.food.FoodHandler;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import rustic.common.blocks.BlockBase;
import rustic.common.blocks.BlockChair;
import rustic.common.blocks.BlockTable;
import rustic.common.items.ModItems;

import java.util.LinkedList;
import java.util.List;

public class RusticRegistry extends ModuleRegistry {

    private static final List<BlockBase> localBlocks = new LinkedList<>();

    @Override
    public void init() {
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.WILDBERRIES)), () -> new FoodHandler(null, new FoodData(4, 0.2F, 0.3F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.IRONBERRIES)), () -> new FoodHandler(null, new FoodData(5, 0.2F, 0.4F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.GRAPES)), () -> new FoodHandler(null, new FoodData(8, 0.0F, 0.5F, 0.0F, 1F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.CHILI_PEPPER)), () -> new FoodHandler(null, new FoodData(6, 0.0F, 0.4F, 0.0F, 0F, 0.9F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.OLIVES)), () -> new FoodHandler(null, new FoodData(4, 0.3F, 0.5F, 0.0F, 1F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.TOMATO)), () -> new FoodHandler(null, new FoodData(4, 0.3F, 0.5F, 0.0F, 1F, 0.0F, 0.0F, 0.0F, 1.0F)));
        CapabilityFood.CUSTOM_FOODS.put(IIngredient.of(new ItemStack(ModItems.GRAPES)), () -> new FoodHandler(null, new FoodData(4, 0.3F, 0.5F, 0.0F, 1F, 0.0F, 0.0F, 0.0F, 1.0F)));
    }

    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();
        for(Tree tree: TFCRegistries.TREES.getValuesCollection()) {
            BlockChair chair = new BlockChair(tree.getRegistryName().getPath());
            BlockTable table = new BlockTable(tree.getRegistryName().getPath());
            r.registerAll(chair, table);

            localBlocks.add(chair);
            localBlocks.add(table);
        }
    }

    @Override
    public void registerModels() {
        for(BlockBase blockBase: localBlocks) {
            blockBase.initModel();
        }
    }
}
