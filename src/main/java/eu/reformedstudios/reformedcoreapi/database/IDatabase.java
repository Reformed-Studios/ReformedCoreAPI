package eu.reformedstudios.reformedcoreapi.database;


import dev.morphia.query.Query;

/**
 * Interface for interacting with the database.
 * <p>
 * Implementation is provided at runtime. Simply inject it using the @Inject annotation on a class field.
 * This will provide an instance at runtime for you to access the database.
 */
public interface IDatabase {

    /**
     * Creates a query for the database.
     *
     * @param tClass The Entity you want to query.
     * @param <T>    The type of the entity.
     * @return Your Morphia Query.
     */
    <T> Query<T> createQuery(Class<T> tClass);

    /**
     * Saves an object in the database.
     *
     * @param o The object you want to store.
     */
    void save(Object o);


}
