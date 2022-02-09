package eu.reformedstudios.reformedcoreapi.modules;

import eu.reformedstudios.reformedcoreapi.events.EventContext;

/**
 * Event manager interface (injectable)
 */
public interface IEventManager {

    /**
     * Method to call when event occurs.
     *
     * @param ctx Eventcontext to pass.
     */
    void execute(EventContext ctx);

}
