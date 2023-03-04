package mrthomas20121.tfcompat.modules.thermal;

import mrthomas20121.tfcompat.api.Reference;
import mrthomas20121.tfcompat.api.module.ModuleBase;

public class ModuleThermalExpansion extends ModuleBase {

    public ModuleThermalExpansion() {
        super(0, Reference.thermalExpansionModule);
        addRegistry(ThermalExpansionModRegistry.class);
    }
}
