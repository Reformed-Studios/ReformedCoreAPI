package eu.reformedstudios.reformedcoreapi.modules;

import com.google.inject.Module;
import org.bukkit.plugin.java.JavaPlugin;

import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayList;
import java.util.List;

public class ReformedModuleBuilder {

	String name = null;
	List<Module> modules = new ArrayList<>();
	JavaPlugin mainClass = null;

	protected ReformedModuleBuilder() {
	}

	public static ReformedModuleBuilder builder() {
		return new ReformedModuleBuilder();
	}

	public ReformedModuleBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public ReformedModuleBuilder withMainClass(JavaPlugin plugin) {
		this.mainClass = plugin;
		return this;
	}

	public ReformedModuleBuilder withModule(Module module) {
		this.modules.add(module);
		return this;
	}

	public ReformedModule build() {
		if(name == null) {
			throw new IllegalArgumentException("You must provide a module name.");
		} if(mainClass == null) {
			throw new IllegalArgumentException("You must provide a main class.");
		}
		return new ReformedModule(name, modules, mainClass);
	}
}
