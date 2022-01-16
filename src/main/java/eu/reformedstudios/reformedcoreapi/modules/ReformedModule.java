package eu.reformedstudios.reformedcoreapi.modules;

import com.google.inject.Module;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class ReformedModule {
	private final List<Module> modules;

	String moduleName;
	JavaPlugin mainClass;


	public List<Module> getModules() {
		return modules;
	}

	public String getModuleName() {
		return moduleName;
	}

	public JavaPlugin getMainClass() {
		return mainClass;
	}

	ReformedModule(@NotNull String moduleName, @NotNull List<Module> modules, @NotNull JavaPlugin mainClass) {
		this.moduleName = moduleName;
		this.modules = modules;
		this.mainClass = mainClass;

		IRegisterable registerable = (IRegisterable) Bukkit.getPluginManager().getPlugin("ReformedCore");
		Objects.requireNonNull(registerable, "Something went wrong trying to register modules.").addModules(List.of(this));
	}


}
