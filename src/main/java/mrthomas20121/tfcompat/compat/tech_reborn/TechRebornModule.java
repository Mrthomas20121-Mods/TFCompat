package mrthomas20121.tfcompat.compat.tech_reborn;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.recipes.heat.HeatRecipe;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.util.Helpers;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class TechRebornModule extends ModuleCore {

    public static Metal refined_iron;

    public TechRebornModule()
    {
        super("techreborn");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new TechRebornRegistry());

        refined_iron = MetalUtils.registerMetal("refined_iron", Metal.Tier.TIER_IV, true, 3000, 1900, 0x0);
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
