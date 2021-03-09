package mrthomas20121.tfcompat.compat.thaumcraft;

import mrthomas20121.rocksalt.utils.MetalUtils;
import mrthomas20121.rocksalt.utils.OredictUtils;
import mrthomas20121.tfcompat.TFCompatConfig;
import mrthomas20121.tfcompat.compat.ArmorMaterialsTFCompat;
import mrthomas20121.tfcompat.compat.ToolMaterialsTFCompat;
import mrthomas20121.tfcompat.library.ModuleCore;
import net.dries007.tfc.api.types.Metal;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ThaumcraftModule extends ModuleCore {

    public ThaumcraftModule()
    {
        super("thaumcraft");
    }

    @Override
    public boolean isLoaded() {
        return Loader.isModLoaded(this.getDep()) && TFCompatConfig.DefaultConfig.modules.thaumcraft;
    }

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        addRegistry(new ThaumcraftRegistry());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        OredictUtils.add("void_metal", "void");
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }
}
