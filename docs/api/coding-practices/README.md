# Coding Practices

Our aim with Reformed was to up the standard for coding in the Minecraft Plugin community. We are implementing a few code practices we are urging you to follow.

?> You can use services like [Codacy](https://codacy.com), which will grade you on your code style.

### Dependency Injection

One of the key problems to solve, was the use of [singletons](https://en.wikipedia.org/wiki/Singleton\_pattern). The use of static fields in any way is generally considered a bad practice. While we won't go into why here, there are a few alternatives to the singleton pattern, that actually follow proper OOP guidelines. Our choice for this is Dependency Injection. With it, you essentially provide all the instances of classes you are going to need, and then you can "inject" them into your classes. Our instructions on getting started with Dependency injection can be found [here](/api/coding-practices/dependency-injection).

