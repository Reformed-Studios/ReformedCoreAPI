package eu.reformedstudios.reformedcoreapi.config;

import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

public abstract class AbstractConfiguration<T> {

    public abstract void save(T instance);

    public abstract YamlConfigurationLoader getLoader();

    public abstract T load();

    public void saveDefaults() {
        this.save(this.load());
    }

}
