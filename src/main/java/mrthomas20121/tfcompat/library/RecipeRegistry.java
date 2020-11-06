package mrthomas20121.tfcompat.library;

import net.dries007.tfc.api.recipes.anvil.AnvilRecipe;
import net.dries007.tfc.api.recipes.barrel.BarrelRecipe;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.recipes.knapping.KnappingRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import javax.annotation.Nonnull;
import java.util.ArrayList;

public abstract class RecipeRegistry {

    private String name;

    public RecipeRegistry(String name)
    {
        this.name=name;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public void init(FMLInitializationEvent event)
    {

    }

    @Nonnull
    public ArrayList<IRecipe> addRecipes(ArrayList<IRecipe> recipes)
    {
        return recipes;
    }

    @Nonnull
    public ArrayList<ResourceLocation> removeRecipes(ArrayList<ResourceLocation> recipes)
    {
        return recipes;
    }

    @Nonnull
    public ArrayList<KnappingRecipe> addKnappingRecipes(ArrayList<KnappingRecipe> recipes)
    {
        return recipes;
    }

    @Nonnull
    public ArrayList<HeatRecipe> addHeatRecipes(ArrayList<HeatRecipe> recipes)
    {
        return recipes;
    }

    @Nonnull
    public ArrayList<BarrelRecipe> addBarrelRecipes(ArrayList<BarrelRecipe> recipes)
    {
        return recipes;
    }

    @Nonnull
    public ArrayList<AnvilRecipe> addAvilRecipes(ArrayList<AnvilRecipe> recipes)
    {
        return recipes;
    }

    public void onRightClick(PlayerInteractEvent.RightClickItem event)
    {

    }

    public Ingredient convertStacks(NonNullList<ItemStack> stacks)
    {
        ArrayList<Ingredient> output = new ArrayList<>();
        for(ItemStack stack : stacks)
        {
            output.add(Ingredient.fromStacks(stack));
        }
        return Ingredient.merge(output);
    }
}
