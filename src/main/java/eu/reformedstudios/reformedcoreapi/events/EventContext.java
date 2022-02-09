package eu.reformedstudios.reformedcoreapi.events;

import com.google.gson.Gson;

import java.util.Map;

/**
 * Class used to construct and pass context about an event.
 */
public class EventContext {

    private final String json;
    private final String name;
    private final Map<String, Object> data;

    /**
     * Construct the eventcontext to pass an event.
     *
     * @param name    Event name, must be <strong>UNIQUE</strong>. Name it something like `MyPlugin:MY_EVENT`.
     * @param context Map of serializable data you want to pass cross-server.
     */
    public EventContext(String name, Map<String, Object> context) {
        Gson gson = new Gson();
        var eventCreator = new EventParser(name, context);

        this.json = gson.toJson(eventCreator);

        this.name = name;
        this.data = context;
    }

    /**
     * Internal use only
     *
     * @param json -
     */
    public EventContext(String json) {
        Gson gson = new Gson();
        var rawContext = gson.fromJson(json, EventParser.class);


        this.json = json;
        this.name = rawContext.redis_id;
        this.data = rawContext.event;
    }

    /**
     * Returns a map with the data that got sent through Redis.
     *
     * @return The event data
     */
    public Map<String, Object> getData() {

        EventParser prs = new Gson().fromJson(this.json, EventParser.class);
        return prs.getEvent();

    }

    /**
     * Returns the event name for identification.
     *
     * @return The event name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the raw json.
     *
     * @return The raw json.
     */
    public String getJson() {
        return this.json;
    }


    /**
     * Internal class for parsing the event JSON.
     */
    private class EventParser {
        String redis_id;
        Map<String, Object> event;

        /**
         * Constructs the event parser (using the event context)
         *
         * @param redis_id The string id for the event.
         * @param event    The event data.
         */
        public EventParser(String redis_id, Map<String, Object> event) {
            this.redis_id = redis_id;
            this.event = event;
        }

        /**
         * Getter for the event id.
         *
         * @return The event id.
         */
        public String getRedis_id() {
            return redis_id;
        }

        /**
         * Getter for the event data.
         *
         * @return The event data.
         */
        public Map<String, Object> getEvent() {
            return event;
        }
    }

}


