package mrthomas20121.tfcompat.modules.morecauldrons;

import mrthomas20121.tfcompat.api.Reference;
import mrthomas20121.tfcompat.api.module.ModuleBase;

public class ModuleMoreCauldrons extends ModuleBase {

    public ModuleMoreCauldrons() {
        super(0, Reference.moreCauldronsModule);
        this.addRegistry(MoreCauldronsRegistry.class);
    }
}
