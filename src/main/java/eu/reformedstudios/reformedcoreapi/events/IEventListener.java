package eu.reformedstudios.reformedcoreapi.events;

/**
 * Interface to implement if you want to listen to an event.
 */
public interface IEventListener {

    /**
     * Method that gets called on event call.
     *
     * @param context EventContext, use this to get data and the event type.
     */
    void onEvent(EventContext context);

}


