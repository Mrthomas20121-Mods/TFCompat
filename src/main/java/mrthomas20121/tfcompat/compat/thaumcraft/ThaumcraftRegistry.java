package mrthomas20121.tfcompat.compat.thaumcraft;

import mrthomas20121.tfcompat.library.RecipeRegistry;
import mrthomas20121.tfcompat.library.helpers.HeatHelper;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.registries.TFCRegistries;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.items.metal.ItemMetal;
import net.dries007.tfc.objects.items.metal.ItemMetalShield;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.items.ItemsTC;

public class ThaumcraftRegistry extends RecipeRegistry {

    public ThaumcraftRegistry()
    {
        super("thaumcraft_registry");
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        HeatHelper.addItemHeat("gemCinnabar", 600, 600);
        HeatHelper.addItemHeat(new ItemStack(ItemsTC.quicksilver), 600, 600);

        for(Metal metal: TFCRegistries.METALS.getValuesCollection()) {
            if(metal.isUsable()) {
                int tier = metal.getTier().ordinal();
                if(metal.isToolMetal()) {
                    ItemStack shield = new ItemStack(ItemMetalShield.get(metal, Metal.ItemType.SHIELD));
                    createAspectBuilder().addAspect(Aspect.PROTECT, 20).build(shield);

                }
                ItemStack lamp = new ItemStack(ItemMetalShield.get(metal, Metal.ItemType.LAMP));
                createAspectBuilder().addAspect(Aspect.LIGHT, 10).addAspect(Aspect.SENSES, 5).build(lamp);

                Metal.ItemType[] types = { Metal.ItemType.SCRAP, Metal.ItemType.DOUBLE_INGOT, Metal.ItemType.DOUBLE_SHEET};
                for(Metal.ItemType type: types) {
                    ItemStack stack = new ItemStack(ItemMetal.get(metal, type));
                    createAspectBuilder().addAspect(Aspect.METAL, 2+tier).build(stack);
                }
            }
        }
    }

    @Override
    public void registerHeatRecipes(IForgeRegistry<HeatRecipe> r) {
        r.register(HeatHelper.addRecipe("cinnabar_to_quicksilver", "gemCinnabar", new ItemStack(ItemsTC.quicksilver), 500));
    }

    private AspectBuilder createAspectBuilder() {
        return new AspectBuilder();
    }

    private class AspectBuilder {

        private AspectList list = new AspectList();

        public AspectBuilder() {

        }

        public AspectBuilder addAspect(Aspect aspect, int amount) {
            this.list.add(aspect, amount);
            return this;
        }

        @SuppressWarnings("deprecation")
        public void build(ItemStack stack) {
            ThaumcraftApi.registerObjectTag(stack, this.list);
        }
    }
}
