package eu.reformedstudios.reformedcoreapi.modules;

import com.google.inject.Module;
import eu.reformedstudios.reformedcoreapi.events.IEventListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.file.Path;
import java.util.*;

/**
 * Builder class to generate a ReformedModule.
 *
 * @author Reformed
 */
public class ReformedModuleBuilder {

    String name = null;
    List<Module> modules = new ArrayList<>();
    List<Class<?>> entities = new ArrayList<>();
    JavaPlugin mainClass = null;
    List<IEventListener> listeners = new ArrayList<>();
    Map<Class<?>, Path> configs = new HashMap<>();

    /**
     * Protected zero-arg-constructor.
     */
    protected ReformedModuleBuilder() {
    }

    /**
     * Static method to obtain an instance of this class.
     *
     * @return A new instance of ReformedModuleBuilder.
     */
    public static ReformedModuleBuilder builder() {
        return new ReformedModuleBuilder();
    }

    /**
     * Sets the name of the ReformedModule.
     *
     * @param name The name you want to set.
     * @return This class for chaining purposes.
     */
    public ReformedModuleBuilder withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Sets the main class of your module.
     *
     * @param plugin The main class of your module.
     * @return This class for chaining purposes.
     */
    public ReformedModuleBuilder withMainClass(JavaPlugin plugin) {
        this.mainClass = plugin;
        return this;
    }

    /**
     * Registers a Guice Module for your module.
     *
     * @param module The GModule you want to register.
     * @return This class for chaining purposes.
     */
    public ReformedModuleBuilder withModule(Module module) {
        this.modules.add(module);
        return this;
    }

    /**
     * Registers a Morphia Entity.
     *
     * @param entity The Entity you want to register.
     * @return This class for chaining purposes.
     */
    public ReformedModuleBuilder withEntity(Class<?> entity) {
        this.entities.add(entity);
        return this;
    }

    /**
     * Registers multiple Morphia Entities
     *
     * @param entities The Entities you want to register.
     * @return This class for chaining purposes.
     */
    public ReformedModuleBuilder withEntities(Class<?>... entities) {
        this.entities.addAll(Arrays.asList(entities));
        return this;
    }

    /**
     * Registers an event listener.
     *
     * @param listener the listener you want to register.
     * @return This class for chaining purposes.
     */
    public ReformedModuleBuilder withListener(IEventListener listener) {
        this.listeners.add(listener);
        return this;
    }

    /**
     * Registers one or more event listeners.
     *
     * @param listeners the listener(s) you want to register.
     * @return This class for chaining purposes.
     */
    public ReformedModuleBuilder withListeners(IEventListener... listeners) {
        this.listeners.addAll(Arrays.asList(listeners));
        return this;
    }


    /**
     * Build method that will return you an instance of ReformedModule, and confirms all registering.
     *
     * @return You instance of ReformedModule.
     */
    public ReformedModule build() {
        if (name == null) {
            throw new IllegalArgumentException("You must provide a module name.");
        }
        if (mainClass == null) {
            throw new IllegalArgumentException("You must provide a main class.");
        }
        return new ReformedModule(name, modules, mainClass, entities, listeners);
    }
}
