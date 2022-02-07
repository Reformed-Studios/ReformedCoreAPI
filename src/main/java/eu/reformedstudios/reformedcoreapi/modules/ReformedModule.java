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

    public List<Module> getModules() {
        return modules;
    }

    public String getModuleName() {
        return moduleName;
    }

    public JavaPlugin getMainClass() {
        return mainClass;
    }

    public List<Class<?>> getEntities() {
        return entities;
    }

    public List<IEventListener> getListeners() {
        return listeners;
    }

    public ICommandManager getCommandManager() {
        return this.commandManager;
    }


}
