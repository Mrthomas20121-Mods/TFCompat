package mrthomas20121.tfcompat.modules.morecauldrons;

import com.mrbysco.morecauldrons.blocks.inspirations.BlockEnhancedCobbleCauldron;
import com.mrbysco.morecauldrons.blocks.inspirations.BlockEnhancedWoodenCauldron;
import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.RegistryHelper;
import mrthomas20121.tfcompat.api.module.ModuleRegistry;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Rock;
import net.dries007.tfc.api.types.Tree;
import net.dries007.tfc.objects.CreativeTabsTFC;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.LinkedList;
import java.util.List;

public class MoreCauldronsRegistry extends ModuleRegistry {

    private static final List<Block> localBlocks = new LinkedList<>();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> r = event.getRegistry();
        for(Tree tree: TFCRegistries.TREES.getValuesCollection()) {
            String wood_name = tree.getRegistryName().getPath();
            localBlocks.add(RegistryHelper.registerBlock(r, TFCompat.MOD_ID+"/"+wood_name, new BlockEnhancedWoodenCauldron(TFCompat.MOD_ID+"/"+wood_name, MapColor.ADOBE), CreativeTabsTFC.CT_WOOD));
        }
        for(Rock rock: TFCRegistries.ROCKS.getValuesCollection()) {
            String rock_name = rock.getRegistryName().getPath();
            localBlocks.add(RegistryHelper.registerBlock(r, TFCompat.MOD_ID+"/"+rock_name, new BlockEnhancedCobbleCauldron(TFCompat.MOD_ID+"/"+rock_name), CreativeTabsTFC.CT_ROCK_BLOCKS));
        }
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> r = event.getRegistry();
        for(Block block: localBlocks) {
            RegistryHelper.registerItem(r, block.getRegistryName().toString(), new ItemBlock(block), block.getCreativeTab());
        }
    }

    @Override
    public void registerModels() {
        localBlocks.forEach(block -> ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory")));
    }
}
