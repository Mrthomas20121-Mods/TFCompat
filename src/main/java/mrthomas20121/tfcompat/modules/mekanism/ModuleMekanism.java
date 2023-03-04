package mrthomas20121.tfcompat.modules.mekanism;

import mrthomas20121.tfcompat.api.Reference;
import mrthomas20121.tfcompat.api.module.ModuleBase;

public class ModuleMekanism extends ModuleBase {

    public ModuleMekanism() {
        super(0, Reference.mekanismModule);
        addRegistry(MekanismModRegistry.class);
    }
}
