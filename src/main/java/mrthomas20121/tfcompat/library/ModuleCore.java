package mrthomas20121.tfcompat.library;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import javax.annotation.Nullable;
import java.util.ArrayList;

public abstract class ModuleCore {

    private String dep;
    private RecipeRegistry registry;

    public ModuleCore(String dep)
    {
        this.dep = dep;
    }

    public ModuleCore(String dep, RecipeRegistry registry)
    {
        this(dep);
        this.registry = registry;
    }

    public void addRegistry(RecipeRegistry registry)
    {
        this.registry = registry;
    }

    @Nullable
    public RecipeRegistry getRegistry() {
        return registry;
    }

    public String getDep()
    {
        return this.dep;
    }

    public abstract boolean isLoaded();

    public abstract void preInit(FMLPreInitializationEvent event);

    public abstract void init(FMLInitializationEvent event);

    public abstract void postInit(FMLPostInitializationEvent event);
}
