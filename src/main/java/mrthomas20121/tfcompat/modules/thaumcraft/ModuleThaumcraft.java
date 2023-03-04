package mrthomas20121.tfcompat.modules.thaumcraft;

import mrthomas20121.tfcompat.api.Reference;
import mrthomas20121.tfcompat.api.module.ModuleBase;

public class ModuleThaumcraft extends ModuleBase {
    public ModuleThaumcraft() {
        super(0, Reference.thaumcraftModule);
        this.addRegistry(ThaumcraftModRegistry.class);
    }

    @Override
    public void init() {
        if(this.getRegistry() != null) {
            this.getRegistry().init();
        }
    }
}
