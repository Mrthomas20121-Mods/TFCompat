package mrthomas20121.tfcompat.api.module;

import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nonnull;

public class ModuleBase implements Comparable<ModuleBase> {

    private final int priority;
    private final String name;
    private ModuleRegistry registry;

    public ModuleBase(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    public <T extends ModuleRegistry> void addRegistry(Class<T> registry) {
        try {
            this.registry = registry.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        MinecraftForge.EVENT_BUS.register(registry);
    }

    public ModuleRegistry getRegistry() {
        return registry;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public void preInit() {

    }

    public void init() {

    }

    public void postInit() {

    }

    public void registerModels() {
        if(this.registry != null) {
            this.registry.registerModels();
        }
    }

    @Override
    public int compareTo(@Nonnull ModuleBase o) {
        return Integer.compare(o.getPriority(), this.priority);
    }
}
