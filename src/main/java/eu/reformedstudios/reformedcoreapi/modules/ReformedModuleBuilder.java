package eu.reformedstudios.reformedcoreapi.modules;

import com.google.inject.Module;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Builder class to generate a ReformedModule.
 * @author Reformed
 */
public class ReformedModuleBuilder {

	String name = null;
	List<Module> modules = new ArrayList<>();
	List<Class<?>> entities = new ArrayList<>();
	JavaPlugin mainClass = null;

	protected ReformedModuleBuilder() {
	}

	/**
	 * Static method to obtain an instance of this class.
	 * @return A new instance of ReformedModuleBuilder.
	 */
	public static ReformedModuleBuilder builder() {
		return new ReformedModuleBuilder();
	}

	/**
	 * Sets the name of the ReformedModule.
	 * @param name The name you want to set.
	 * @return This class for chaining purposes.
	 */
	public ReformedModuleBuilder withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Sets the main class of your module.
	 * @param plugin The main class of your module.
	 * @return This class for chaining purposes.
	 */
	public ReformedModuleBuilder withMainClass(JavaPlugin plugin) {
		this.mainClass = plugin;
		return this;
	}

	/**
	 * Registers a Guice Module for your module.
	 * @param module The GModule you want to register.
	 * @return This class for chaining purposes.
	 */
	public ReformedModuleBuilder withModule(Module module) {
		this.modules.add(module);
		return this;
	}

	/**
	 * Registers a Morphia Entity.
	 * @param entity The Entity you want to register.
	 * @return This class for chaining purposes.
	 */
	public ReformedModuleBuilder withEntity(Class<?> entity) {
		this.entities.add(entity);
		return this;
	}

	/**
	 * Registers multiple Morphia Entities
	 * @param entities The Entities you want to register.
	 * @return This class for chaining purposes.
	 */
	public ReformedModuleBuilder withEntities(Class<?> ... entities) {
		this.entities.addAll(Arrays.asList(entities));
		return this;
	}

	/**
	 * Build method that will return you an instance of ReformedModule, and confirms all registering.
	 * @return You instance of ReformedModule.
	 */
	public ReformedModule build() {
		if(name == null) {
			throw new IllegalArgumentException("You must provide a module name.");
		} if(mainClass == null) {
			throw new IllegalArgumentException("You must provide a main class.");
		}
		return new ReformedModule(name, modules, mainClass, entities);
	}
}
