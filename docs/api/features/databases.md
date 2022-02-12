# Databases

!> Make sure to run database code asynchronously with something like the [BukkitScheduler](https://hub.spigotmc.org/javadocs/spigot/org/bukkit/scheduler/BukkitScheduler.html).

ReformedCore makes the user only have to authenticate with their database in one place. We use an ODM (Morphia) to map this database to Java objects.

### Getting started

?> While we won't go into very much depth in this documentation, check out Morphia's documentation on [Mapping](https://morphia.dev/morphia/2.2/mapping.html) and [Queries](https://morphia.dev/morphia/2.2/queries.html)!

#### Creating a collection

To get started, create a Java class annotated with the `@Entity` annotation. Something like this:

```java
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import dev.morphia.annotations.Property;
import org.bson.types.ObjectId;

@Entity ("testv2")
public class Testing {
    @Id
    private ObjectId id;

    @Property ("test")
    private String test;

    public Testing(String test) {
        this.test = test;
    }

}
```
!> _Make sure_ your collection name has some kind of unique identifier of your plugin. Ex: `yourplugin_player` instead of `player`, as you might run into duplicate collections.

As you can see, you can put the collection name inside the parentheses of the annotation. Along with this, you can declare fields in the schema with the `@Property` annotation, with their respective names. If you don't specify a name in either of these annotations, they will be automatically inferred.

After declaring the class, you have to insert it into the ReformedModuleBuilder. If your class is called `DatabaseEntity`, do it as so:

```java
ReformedModuleBuilder.builder()
    ...
    .withEntity(DatabaseEntity.class)
    ...
    .build()
```

?> You can also use the `withEntities` method if you need to pass multiple entities without having to chain too many calls.

#### Saving

To save to the database, [inject](../coding-practices/dependency-injection.md#injecting-into-fields) the `IDatabase` class. You can then run IDatabase#save with an instance of your object. Yes. That's it.

#### Querying

To create a Query, use the IDatabase#createQuery method. You have to pass the `Class` instance of your object. So if your class is called `DatabasePlayer`, you need to pass `DatabasePlayer.class`. Follow the [Morphia documentation for queries](https://morphia.dev/morphia/2.2/queries.html) for more information on this.

#### Updating & Deleting

You can update and delete entries by first querying them.

See: [Querying](databases.md#querying).
