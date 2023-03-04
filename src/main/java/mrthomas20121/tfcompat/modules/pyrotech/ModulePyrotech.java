package mrthomas20121.tfcompat.modules.pyrotech;

import mrthomas20121.tfcompat.api.Reference;
import mrthomas20121.tfcompat.api.module.ModuleBase;

public class ModulePyrotech extends ModuleBase {

    public ModulePyrotech() {
        super(0, Reference.pyrotechModule);
        addRegistry(PyrotechModRegistry.class);
    }
}
