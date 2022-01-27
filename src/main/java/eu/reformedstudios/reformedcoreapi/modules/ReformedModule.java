package eu.reformedstudios.reformedcoreapi.modules;

import com.google.inject.Module;
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
	Object mainClass;
	List<Class<?>> entities;
	private List<IEventListener> listeners;

	public List<Module> getModules() {
		return modules;
	}

	public String getModuleName() {
		return moduleName;
	}

	public Object getMainClass() {
		return mainClass;
	}

	public List<Class<?>> getEntities() {
		return entities;
	}

	public List<IEventListener> getListeners() {
		return listeners;
	}

	ReformedModule(
					@NotNull String moduleName,
					@NotNull List<Module> modules,
					@NotNull Object mainClass,
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
	}


}
