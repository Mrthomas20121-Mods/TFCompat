package mrthomas20121.tfcompat.compat.rustic;

import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Tree;
import net.minecraft.block.Block;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import rustic.common.blocks.BlockBase;
import rustic.common.blocks.BlockChair;
import rustic.common.blocks.BlockTable;

import java.util.ArrayList;

public class RusticBlocks {

    public static ArrayList<BlockBase> rusticBlocks = new ArrayList<>();

    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> r = event.getRegistry();
        for(Tree tree: TFCRegistries.TREES.getValuesCollection())
        {
            BlockChair chair = new BlockChair(tree.getRegistryName().getPath());
            BlockTable table = new BlockTable(tree.getRegistryName().getPath());
            r.registerAll(chair, table);
            rusticBlocks.add(chair);
            rusticBlocks.add(table);
        }
    }

    public static void registerModels(ModelRegistryEvent event)
    {
        for(BlockBase blockBase : RusticBlocks.rusticBlocks)
        {
            blockBase.initModel();
        }
    }
}
