# Configuration

Configuration files are made incredibly easy with the ReformedCore API. Let's have a look how we would get data normally, and with RCAPI.

```yaml
test-string: "Test information"
subsection:
  test-integer: 231
```

<!-- tabs:start -->

<!-- tab:Spigot (SnakeYAML) -->
```java
JavaPlugin mainPlugin; // plugin instance

String testString = mainPlugin.getConfig().getString("test-string");
int testInteger = mainPlugin.getConfig().getInt("subsection.test-integer");
```

While this approach may not look the worst in terms of readability, it is an absolute pain to manage this, especially with versioning configs, and overall making sure your keys align.

<!-- tab:ReformedCore (Configurate) -->

!> Configurate currently [does not implement comments in YAML](https://github.com/SpongePowered/Configurate/pull/175).


```java
@Inject
private IConfigurationManager cfgManager;

cfgManager.registerConfig(YourConfig.class, new File(getDataFolder(), "config.yaml").toPath());
AbstractConfiguration<YourConfig> handler = cfgManager.getConfig(YourConfig.class);
YourConfig config = handler.load();
config.setTestString("More testing");
handler.save(config);
```

While this may look like more code, it allows you to declare your configurations **as code**, meaning you won't have to manually fill up a YAML file beforehand and keep track of changes and whatnot. You just edit and save a Java Object. Simple as that.

<!-- tabs:end -->


## Getting started

### Creating your config Object

?> Check out [this example](https://github.com/SpongePowered/Configurate/wiki/Object-Mapper#bringing-it-all-together) in the Configurate wiki for more information (you can ignore the registering, as RC abstracts that away from you)

```java
/**
 * Let's say we're mimicking the config shown above.
 */
@ConfigSerializable
public class ExampleConfiguration {

   String testString = "Test information"; // assigning -> setting default.
   ExampleConfigurationSection subsection = new ExampleConfigurationSection(); 
   // Other objects are allowed, as long as they are serialized using a serializer
   // Or by annotating them with @ConfigSerializable.
 
}
```

```java
@ConfigSerializable
public class ExampleConfigurationSection {
   int testInteger = 231;
}
```

Simple as that! It is also recommended to add stuff like getters and setters, but for this example that would just add a bunch of unnecesary clutter.

### Registering your configuration

To register your configuration, simply inject the `IConfigurationManager` and call the registerConfig method on it.

```java
@Inject
private IConfigurationManager cfgManager;
...

cfgManager.registerConfig(ExampleConfiguration.class, new File(getDataFolder(), "config.yaml").getPath());
```

Here, we're getting the plugin's data folder by calling getDataFolder() on the JavaPlugin instance, and creating a new File out of it. We then call getPath() on it to get the raw path that we need.

#### Saving defaults

It's recommended to save the defaults in your onEnable method. To do this, simply call saveDefaults() on the AbstractConfiguration.

```java
AbstractConfiguration<ExampleConfiguration> config = cfgManager.getConfig(ExampleConfiguration.class);
config.saveDefaults();
```

### Editing and saving

To get your config, call the load() method on the AbstractConfiguration.

```java
AbstractConfiguration<ExampleConfiguration> configLoader = cfgManager.getConfig(ExampleConfiguration.class);
ExampleConfiguration config = config.load();
```

You can then change whatever you want about the config object, and then save it with the save() method.

```java
configLoader.save(config);
```
