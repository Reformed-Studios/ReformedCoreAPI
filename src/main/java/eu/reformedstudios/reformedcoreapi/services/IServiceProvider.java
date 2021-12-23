package eu.reformedstudios.reformedcoreapi.services;

public interface IServiceProvider {
    public <T extends IService> T getService(Class<T> clazz);
    public <T extends IService> T registerService(Class<T> clazz, T instance);

}
