package eu.reformedstudios.reformedcoreapi.modules;

import com.google.inject.Module;

import java.util.Collection;
import java.util.List;

public interface IRegisterable {

	void addModules(List<ReformedModule> modules);
}
