package mrthomas20121.tfcompat;

import mrthomas20121.tfcompat.api.Reference;
import mrthomas20121.tfcompat.api.module.ModuleBase;
import mrthomas20121.tfcompat.client.GuiHandler;
import mrthomas20121.tfcompat.config.TFCompatConfig;
import mrthomas20121.tfcompat.modules.mekanism.ModuleMekanism;
import mrthomas20121.tfcompat.modules.morecauldrons.ModuleMoreCauldrons;
import mrthomas20121.tfcompat.modules.nuclearcraft.ModuleNuclearcraft;
import mrthomas20121.tfcompat.modules.pyrotech.ModulePyrotech;
import mrthomas20121.tfcompat.modules.rustic.ModuleRustic;
import mrthomas20121.tfcompat.modules.tech_reborn.ModuleTechReborn;
import mrthomas20121.tfcompat.modules.thaumcraft.ModuleThaumcraft;
import mrthomas20121.tfcompat.modules.thermal.ModuleThermalExpansion;
import mrthomas20121.tfcompat.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = TFCompat.MOD_ID, name = TFCompat.NAME, version = TFCompat.VERSION, dependencies = TFCompat.DEPENDENCIES)
public class TFCompat {

    public static final String MOD_ID = "tfcompat";
    public static final String NAME = "TFCompat";
    public static final String VERSION = "1.3.1";
    public static final String DEPENDENCIES =
            "required-after:forge@[14.23.5.2847,);"
            + "required-after:rocksalt@[1.0.1,);"
            + "required-after:tfc;"
            + "after:tfcmetallum;"
            + "after:tfctech;"
            + "after:firmalife;"
            + "after:betterwithmods;"
            + "after:pyrotech;"
            + "after:mekanism;"
            + "after:improvedbackpacks;"
            + "after:techreborn;"
            + "after:thermalexpansion;"
            + "after:ironbackpacks;"
            + "after:thaumcraft;";

    @Mod.Instance
    public static TFCompat instance;

    private static Logger logger;

    @SidedProxy(clientSide = "mrthomas20121.tfcompat.proxy.ClientProxy", serverSide = "mrthomas20121.tfcompat.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Logger getLog()
    {
        return logger;
    }

    private static final List<ModuleBase> modules = new ArrayList<>();

    public static List<ModuleBase> getModules() {
        return modules;
    }

    public <T extends ModuleBase> void registerModule(Class<T> moduleClass) {
        try {
            T module = moduleClass.newInstance();
            modules.add(module);
        }
        catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();

        if(TFCompatConfig.MODULES.containsKey(Reference.mekanismModule) && Reference.isModLoaded(Reference.mekanism)) {
            this.registerModule(ModuleMekanism.class);
        }
        if(TFCompatConfig.MODULES.containsKey(Reference.moreCauldronsModule) && Reference.isModLoaded(Reference.moreCauldrons)) {
            this.registerModule(ModuleMoreCauldrons.class);
        }
        if(TFCompatConfig.MODULES.containsKey(Reference.nuclearcraftModule) && Reference.isModLoaded(Reference.nuclearcraft)) {
            this.registerModule(ModuleNuclearcraft.class);
        }
        if(TFCompatConfig.MODULES.containsKey(Reference.pyrotechModule) && Reference.isModLoaded(Reference.pyrotech)) {
            this.registerModule(ModulePyrotech.class);
        }
        if(TFCompatConfig.MODULES.containsKey(Reference.rusticModule) && Reference.isModLoaded(Reference.rustic)) {
            this.registerModule(ModuleRustic.class);
        }
        if(TFCompatConfig.MODULES.containsKey(Reference.techRebornModule) && Reference.isModLoaded(Reference.techReborn)) {
            this.registerModule(ModuleTechReborn.class);
        }
        if(TFCompatConfig.MODULES.containsKey(Reference.thaumcraftModule) && Reference.isModLoaded(Reference.thaumcraft)) {
            this.registerModule(ModuleThaumcraft.class);
        }
        if(TFCompatConfig.MODULES.containsKey(Reference.thermalExpansionModule) && Reference.isModLoaded(Reference.thermalexpansion)) {
            this.registerModule(ModuleThermalExpansion.class);
        }

        modules.forEach(ModuleBase::preInit);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        modules.forEach(ModuleBase::init);

        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        modules.forEach(ModuleBase::postInit);
    }
}

