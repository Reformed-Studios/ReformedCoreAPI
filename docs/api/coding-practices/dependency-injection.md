# Dependency Injection

In short: Our Dependency Injection lets you inject Object instances into your classes, without having to manually pass them through constructors.

### Injecting into fields

?> For an explanation of the difference between Modules and GModules, check our [Frequently Used Terms](/api/frequently-used-terms) page.

To get started, make your Module with the ReformedModuleBuilder. Important is that you pass the instance of your main class, as it will let us inject the dependencies into it, and all its underlying classes.

```java
ReformedModuleBuilder.builder()
    ...
    .withMainClass(this)
    ...
    .build();
```

And that's it! You can now inject Services into your classes, which you can do as follows:

```java
public class ReformedApiExample extends JavaPlugin {

	@Inject
	private ExampleService exampleService;

	@Override
	public void onEnable() {
		exampleService.printHello();
	}
}
```

?> You can find our full API Example on [Github](https://github.com/Reformed-Studios/ReformedApiExample).

Note the use of the `@Inject` annotation. This is required to mark a field as injectable.

### Creating your own Services

To create a service and use it for DI, you first need a GModule. You can create a GModule by extending the AbstractModule class. We recommend naming it something like `YourProjectModule.java`.

```java
public class ExampleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IExampleService.class).toInstance(new ExampleService());
    }
    
}
```

You can then override the `configure()` method. In this method, you can bind a Class to an Object instance. This class can, and in most cases should be an interface, while the object should be an instance of the interface implementation. More on this in our [Coding Practices](./).

!> When using an interface to bind to, make sure you use the interface as the field type when injecting.

Now you need to pass this GModule into the ReformedModuleBuilder.

```java
ReformedModuleBuilder.builder()
    ...
    .withModule(new ExampleModule())
    ...
    .build();
```
