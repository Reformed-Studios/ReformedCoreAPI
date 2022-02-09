package eu.reformedstudios.reformedcoreapi.modules;

import com.google.inject.Module;
import eu.reformedstudios.reformedcoreapi.commands.ICommandManager;
import eu.reformedstudios.reformedcoreapi.config.AbstractConfiguration;
import eu.reformedstudios.reformedcoreapi.events.IEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Module used to register stuff in the API.
 */
public class ReformedModule {
    private final List<Module> modules;
    private final List<IEventListener> listeners;
    private final Map<Class<?>, AbstractConfiguration<?>> configurations;
    String moduleName;
    JavaPlugin mainClass;
    List<Class<?>> entities;
    private IRegisterable registrable;
    private ICommandManager commandManager;

    /**
     * Package-private constructor to construct the ReformedModule.
     *
     * @param moduleName     The name of your module.
     * @param modules        The Guice modules you want to register.
     * @param mainClass      The main class of your module.
     * @param entities       The database entities you want to use.
     * @param eventListeners The event listeners you want to register.
     */
    ReformedModule(
            @NotNull String moduleName,
            @NotNull List<Module> modules,
            @NotNull JavaPlugin mainClass,
            List<Class<?>> entities,
            List<IEventListener> eventListeners
    ) {
        this.configurations = new HashMap<>();
        this.moduleName = moduleName;
        this.modules = modules;
        this.mainClass = mainClass;
        this.entities = entities;
        this.listeners = eventListeners;

        IRegistering registering = ((IRegistering) Bukkit.getPluginManager().getPlugin("ReformedCore"));

        if (registering == null) {
            System.out.println("Something went wrong registering a core mechanic.");
            return;
        }

        this.registrable = registering.handleRegistering();

        registrable.addModules(List.of(this));
        this.listeners.forEach(registrable::registerListener);

        this.commandManager = registrable.getCommandManager(this);


    }

    /**
     * Getter for the Guice modules.
     *
     * @return The Guice modules.
     */
    public List<Module> getModules() {
        return modules;
    }

    /**
     * Getter for the module name.
     *
     * @return The module name.
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Getter for the main class.
     *
     * @return The main class.
     */
    public JavaPlugin getMainClass() {
        return mainClass;
    }

    /**
     * Getter for the database entities.
     *
     * @return The database entities.
     */
    public List<Class<?>> getEntities() {
        return entities;
    }

    /**
     * Getter for the {@link eu.reformedstudios.reformedcoreapi.events.IEventListener}s.
     *
     * @return The List of {@link eu.reformedstudios.reformedcoreapi.events.IEventListener}.
     */
    public List<IEventListener> getListeners() {
        return listeners;
    }

    /**
     * Getter for the {@link eu.reformedstudios.reformedcoreapi.commands.ICommandManager}.
     *
     * @return The {@link eu.reformedstudios.reformedcoreapi.commands.ICommandManager}.
     */
    public ICommandManager getCommandManager() {
        return this.commandManager;
    }


}
