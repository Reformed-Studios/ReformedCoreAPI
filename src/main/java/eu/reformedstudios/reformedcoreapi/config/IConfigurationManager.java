package eu.reformedstudios.reformedcoreapi.config;

import java.nio.file.Path;

/**
 * Interface you can inject to manage configs.
 */
public interface IConfigurationManager {

    /**
     * Registers a config to use it later on.
     *
     * @param clazz The class (annotated with {@link org.spongepowered.configurate.objectmapping.ConfigSerializable}) that maps your config.
     * @param path  Path to your config file.
     */
    void registerConfig(Class<?> clazz, Path path);

    /**
     * Get the AbstractConfiguration instance for a class with the
     * {@link org.spongepowered.configurate.objectmapping.ConfigSerializable} annotation.
     *
     * @param clazz The configuration class.
     * @param <T>   The configuration type for type checking during compile time.
     * @return The {@link eu.reformedstudios.reformedcoreapi.config.AbstractConfiguration} instance.
     */
    <T> AbstractConfiguration<T> getConfig(Class<T> clazz);
}
