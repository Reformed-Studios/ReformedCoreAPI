package eu.reformedstudios.reformedcoreapi.modules;

import eu.reformedstudios.reformedcoreapi.events.EventContext;
import eu.reformedstudios.reformedcoreapi.events.IEventListener;

import java.util.List;

public interface IRegisterable {

	void addModules(List<ReformedModule> modules);

	void runEvent(EventContext ctx);

	void registerListener(IEventListener listener);

}
