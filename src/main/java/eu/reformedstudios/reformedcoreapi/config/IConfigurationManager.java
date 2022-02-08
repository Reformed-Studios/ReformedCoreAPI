package eu.reformedstudios.reformedcoreapi.config;

import java.nio.file.Path;

/**
 * Interface you can inject to manage configs.
 */
public interface IConfigurationManager {

    /**
     * Registers a config to use it later on.
     *
     * @param clazz The class (annotated with @ConfigSerializable) that maps your config.
     * @param path  Path to your config file.
     */
    void registerConfig(Class<?> clazz, Path path);

    <T> AbstractConfiguration<T> getConfig(Class<T> clazz);
}
