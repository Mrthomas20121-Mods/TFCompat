package mrthomas20121.tfcompat.compat.improvedbackpacks;

import mrthomas20121.tfcompat.client.GuiHandler;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import mrthomas20121.tfcompat.library.recipes.IHeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import ru.poopycoders.improvedbackpacks.init.ModItems;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public class BackpackRegistry extends RecipeRegistry {

    public BackpackRegistry()
    {
        super("backpack_registry");
    }

    public void init(FMLInitializationEvent event) {
        HeatHelper.addItemHeat(new ItemStack(ModItems.BOUND_LEATHER), 600, 580);
        HeatHelper.addItemHeat(new ItemStack(ModItems.TANNED_LEATHER), 600, 580);
        OreDictionary.registerOre("tannedLeather", ModItems.TANNED_LEATHER);
    }

    @Nonnull
    @Override
    public ArrayList<HeatRecipe> addHeatRecipes(ArrayList<HeatRecipe> recipes) {
        recipes.add(HeatHelper.addRecipe("improved_tanned_leather", new ItemStack(ModItems.BOUND_LEATHER), new ItemStack(ModItems.TANNED_LEATHER), 500));
        return recipes;
    }
    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        if(event.getItemStack().getItem() == ModItems.TANNED_LEATHER)
        {
            EntityPlayer player = event.getEntityPlayer();
            World world = event.getWorld();
            if (!world.isRemote && !player.isSneaking())
            {
                GuiHandler.openGui(world, player.getPosition(), player, GuiHandler.Type.PORCELAIN);
            }
        }
    }
}
