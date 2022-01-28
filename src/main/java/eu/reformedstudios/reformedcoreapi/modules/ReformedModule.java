package eu.reformedstudios.reformedcoreapi.modules;

import com.google.inject.Module;
import eu.reformedstudios.reformedcoreapi.commands.ICommandManager;
import eu.reformedstudios.reformedcoreapi.events.IEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

/**
 * Module used to register stuff in the API.
 */
public class ReformedModule {
	private final List<Module> modules;

	String moduleName;
	JavaPlugin mainClass;
	List<Class<?>> entities;
	private List<IEventListener> listeners;
	private ICommandManager commandManager;

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

	ReformedModule(
					@NotNull String moduleName,
					@NotNull List<Module> modules,
					@NotNull JavaPlugin mainClass,
					List<Class<?>> entities,
					List<IEventListener> eventListeners
					) {
		this.moduleName = moduleName;
		this.modules = modules;
		this.mainClass = mainClass;
		this.entities = entities;
		this.listeners = eventListeners;

		IRegistering registring = ((IRegistering) Bukkit.getPluginManager().getPlugin("ReformedCore"));

		if(registring == null) {
			System.out.println("Something went wrong registering a core mechanic.");
			return;
		}

		IRegisterable registrable = registring.handleRegistering();
		
		registrable.addModules(List.of(this));
		this.listeners.forEach(registrable::registerListener);

		this.commandManager = registrable.getCommandManager(this);

	}


}
