package eu.reformedstudios.reformedcoreapi.modules;

import eu.reformedstudios.reformedcoreapi.commands.ICommandManager;
import eu.reformedstudios.reformedcoreapi.events.EventContext;
import eu.reformedstudios.reformedcoreapi.events.IEventListener;

import java.util.List;

public interface IRegisterable {

	void addModules(List<ReformedModule> modules);

	void runEvent(EventContext ctx);

	ICommandManager getCommandManager(ReformedModule module);

	void registerListener(IEventListener listener);

}
