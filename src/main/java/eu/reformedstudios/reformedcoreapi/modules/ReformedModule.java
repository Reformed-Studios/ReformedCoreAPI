package eu.reformedstudios.reformedcoreapi.modules;

import com.google.inject.Module;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ReformedModule {
	private final List<Module> modules;

	public List<Module> getModules() {
		return modules;
	}

	public String getModuleName() {
		return moduleName;
	}

	public JavaPlugin getMainClass() {
		return mainClass;
	}

	String moduleName;
	JavaPlugin mainClass;

	ReformedModule(@NotNull String moduleName, @NotNull List<Module> modules, @NotNull JavaPlugin mainClass) {
		this.moduleName = moduleName;
		this.modules = modules;
		this.mainClass = mainClass;

		IRegisterable registerable = (IRegisterable) Bukkit.getPluginManager().getPlugin("ReformedCore");
		if(registerable != null) {
			registerable.addModules(List.of(this));
		} else {
			throw new NullPointerException("Something went wrong trying to register modules.");
		}
	}


}
