package mrthomas20121.tfcompat.compat.betterwithmods;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.Powder;
import net.dries007.tfc.objects.items.ItemPowder;
import net.dries007.tfc.util.Helpers;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

public class BetterWithModsModule extends ModuleCore {

    private BetterWithModsRecipes recipeModule = Helpers.getNull();

    public BetterWithModsModule()
    {
        super("module_bwm", "betterwithmods");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        recipeModule = new BetterWithModsRecipes();
        MetalUtils.registerMetal("soulforged_steel", Metal.Tier.TIER_IV, true, 1500, 1300, 0x0);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        // oredict registry
        OreDictionary.registerOre("dustCarbon", ItemPowder.get(Powder.CHARCOAL));
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void initRecipes(IForgeRegistry<IRecipe> r) {
        recipeModule.registerRecipes(r);
    }
}
