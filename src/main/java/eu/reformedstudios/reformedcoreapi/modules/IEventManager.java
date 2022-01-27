package eu.reformedstudios.reformedcoreapi.modules;

import eu.reformedstudios.reformedcoreapi.events.EventContext;

public interface IEventManager {

	void execute(EventContext ctx);

}
