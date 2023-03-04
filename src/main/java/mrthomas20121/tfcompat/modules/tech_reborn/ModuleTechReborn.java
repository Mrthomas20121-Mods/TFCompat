package mrthomas20121.tfcompat.modules.tech_reborn;

import mrthomas20121.tfcompat.api.Reference;
import mrthomas20121.tfcompat.api.module.ModuleBase;

public class ModuleTechReborn extends ModuleBase {

    public ModuleTechReborn() {
        super(0, Reference.techRebornModule);
        addRegistry(TechRebornModRegistry.class);
    }
}
