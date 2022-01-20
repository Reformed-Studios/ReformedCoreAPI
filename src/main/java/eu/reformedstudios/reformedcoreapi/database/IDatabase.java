package eu.reformedstudios.reformedcoreapi.database;


import dev.morphia.query.Query;

public interface IDatabase {

	<T> Query<T> createQuery(Class<T> tClass);
	void save(Object o);


}
