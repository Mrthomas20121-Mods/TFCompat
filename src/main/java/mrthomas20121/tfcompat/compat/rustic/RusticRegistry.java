package mrthomas20121.tfcompat.compat.rustic;

import mrthomas20121.tfcompat.library.RecipeRegistry;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Tree;
import net.minecraft.block.Block;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;
import rustic.common.blocks.BlockBase;
import rustic.common.blocks.BlockChair;
import rustic.common.blocks.BlockTable;

import java.util.ArrayList;

public class RusticRegistry extends RecipeRegistry {

    public static ArrayList<BlockBase> rusticBlocks = new ArrayList<>();

    public RusticRegistry()
    {
        super("rustic_registry");
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
