package mrthomas20121.tfcompat.api;

import mrthomas20121.tfcompat.TFCompat;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class RegistryHelper {

    public static Item registerItem(IForgeRegistry<Item> r, String registryName, Item item, CreativeTabs tabs) {
        item.setRegistryName(registryName);
        item.setTranslationKey(TFCompat.MOD_ID+"."+registryName.replace("/", "_"));
        item.setCreativeTab(tabs);
        r.register(item);
        return item;
    }

    public static Block registerBlock(IForgeRegistry<Block> r, String registryName, Block block, CreativeTabs tabs) {
        block.setRegistryName(registryName);
        block.setTranslationKey(TFCompat.MOD_ID+"."+registryName.replace("/", "_"));
        block.setCreativeTab(tabs);
        r.register(block);
        return block;
    }
}
