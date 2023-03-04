package mrthomas20121.tfcompat.modules.nuclearcraft;

import mrthomas20121.tfcompat.api.Reference;
import mrthomas20121.tfcompat.api.module.ModuleBase;

public class ModuleNuclearcraft extends ModuleBase {

    public ModuleNuclearcraft() {
        super(0, Reference.nuclearcraftModule);

        addRegistry(NuclearcraftRegistry.class);
    }
}
