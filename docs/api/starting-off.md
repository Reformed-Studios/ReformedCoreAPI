# Starting off

!> This API is for **experienced developers** only. Don't use it as a shortcut to not having to write code yourself. It is important to learn these things as it will make you a much better programmer in the long run.

?> Check out our [Javadoc](https://repo.reformedstudios.eu/javadoc/releases/eu/reformedstudios/reformed-core-api/latest) for more documentation on specific classes in the API.


### Installation


<!-- tabs:start -->

<!-- tab:Maven -->

First, declare our repository like so:

```xml
<repository>
  <id>reformed-repo</id>
  <url>https://repo.reformedstudios.eu/releases</url>
</repository>
```

Then, add the dependency like so:

```xml
<dependency>
  <groupId>eu.reformedstudios</groupId>
  <artifactId>reformed-core-api</artifactId>
  <version>LATEST</version>
  <scope>provided</scope>
</dependency>
```

<!-- tab:Gradle (Groovy) -->

First, add our repository like so:

```groovy
repositories {
  maven {
    url "https://repo.reformedstudios.eu/releases"
  }
}
```

Then add the dependency:

```groovy
dependencies {
  implementation "eu.reformedstudios:reformed-core-api:LATEST"
}
```

<!-- tab:Gradle (Kotlin) -->

First, add our repository like so:

```kotlin
repositories {
  maven {
    url = uri("https://repo.reformedstudios.eu/releases")
  }
}
```

Then add the dependency:

```kotlin
dependencies {
  implementation("eu.reformedstudios:reformed-core-api:LATEST")
}
```
<!-- tabs:end -->

?> You can find the latest version from our [Maven Repository](https://repo.reformedstudios.eu).

### Code practices

Before you start using our API to code your very own amazing plugins, we recommend you go and read the following page. It will give you an introduction to a good coding style, which may be more important than you'd think.

[coding-practices](coding-practices/)

