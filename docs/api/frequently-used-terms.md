# Frequently Used Terms

<details>

<summary>Modules</summary>

We are going to be distinguishing between two different modules. ReformedModules, which we will be referring to as just Modules, and Guice Modules, which we will be referring to as GModules.&#x20;

### Modules

Every plugin that interacts with the Reformed API is a Module. When you initialize the API, you create this module with certain parameters, so we can distinguish between different plugins using our API.

### GModules

GModules are modules used to bind Interfaces or Classes to Class Instances, to prepare them for Dependency injection. More info in our [DI](coding-practices/dependency-injection.md) page.

</details>
