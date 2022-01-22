package eu.reformedstudios.reformedcoreapi.modules;


import java.util.List;

/**
 * Interface for handeling Dependency Injection.
 */
public interface IRegisterable {

	void addModules(List<ReformedModule> modules);
}
