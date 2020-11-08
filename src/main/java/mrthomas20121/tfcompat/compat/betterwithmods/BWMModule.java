package mrthomas20121.tfcompat.compat.betterwithmods;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.types.Metal;
import net.dries007.tfc.objects.Powder;
import net.dries007.tfc.objects.items.ItemPowder;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class BWMModule extends ModuleCore {

    public BWMModule()
    {
        super("betterwithmods");
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        this.addRegistry(new BWMRegistry());
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
}
