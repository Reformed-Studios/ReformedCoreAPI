package eu.reformedstudios.reformedcoreapi.config;

import java.nio.file.Path;

public interface IConfigurationManager {

    void registerConfig(Class<?> clazz, Path path);

    <T> AbstractConfiguration<T> getConfig(Class<T> clazz);
}
