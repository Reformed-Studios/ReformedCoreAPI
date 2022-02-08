package eu.reformedstudios.reformedcoreapi.config;

import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

/**
 * Abstract class to manage ONE configuration file.
 *
 * @param <T> Type of config.
 */
public abstract class AbstractConfiguration<T> {

    /**
     * Saves the passed instance to the attached file.
     *
     * @param instance The instance you want to save.
     */
    public abstract void save(T instance);

    /**
     * Get the config loader.
     *
     * @return The YamlConfigurationLoader
     */
    public abstract YamlConfigurationLoader getLoader();

    /**
     * Loads the config file.
     *
     * @return an instance with the current data in the config file.
     */
    public abstract T load();

    /**
     * Method that saves the current data to disk. <br />
     * Use this method in onEnable to ensure a config file is in the data directory.
     */
    public void saveDefaults() {
        this.save(this.load());
    }

}
