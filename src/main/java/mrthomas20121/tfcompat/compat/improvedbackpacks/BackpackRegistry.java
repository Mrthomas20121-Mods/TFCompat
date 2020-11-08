package mrthomas20121.tfcompat.compat.improvedbackpacks;

import mrthomas20121.tfcompat.TFCompat;
import mrthomas20121.tfcompat.api.knapping.Types;
import mrthomas20121.tfcompat.client.GuiHandler;
import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipeSimple;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipeSimple;
import net.dries007.tfc.objects.inventory.ingredient.IIngredient;
import net.dries007.tfc.util.OreDictionaryHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
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
        recipes.add(new HeatRecipeSimple(IIngredient.of(new ItemStack(ModItems.BOUND_LEATHER)), new ItemStack(ModItems.TANNED_LEATHER), 500).setRegistryName(TFCompat.MODID, "tanned_leather"));
        return recipes;
    }

    @Nonnull
    @Override
    public ArrayList<KnappingRecipe> addKnappingRecipes(ArrayList<KnappingRecipe> recipes) {
        recipes.add(new KnappingRecipeSimple(Types.TANNED_LEATHER, false, new ItemStack(ModItems.BACKPACK, 1), "X   X", "X   X", "X   X", "X   X", "XXXXX").setRegistryName(TFCompat.MODID, "backpack"));
        return super.addKnappingRecipes(recipes);
    }

    @Override
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        if(OreDictionaryHelper.doesStackMatchOre(event.getItemStack(), "tannedLeather") && event.getHand() == EnumHand.MAIN_HAND)
        {
            EntityPlayer player = event.getEntityPlayer();
            World world = event.getWorld();
            if (!world.isRemote && !player.isSneaking())
            {
                GuiHandler.openGui(world, player.getPosition(), player, GuiHandler.Type.TANNED_LEATHER);
            }
        }
    }
}
