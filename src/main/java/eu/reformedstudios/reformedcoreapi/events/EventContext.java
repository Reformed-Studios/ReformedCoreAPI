package eu.reformedstudios.reformedcoreapi.events;

import com.google.gson.Gson;

import java.util.Map;

public class EventContext {

	private final String json;
	private final String name;
	private final Map<String, Object> data;

	public EventContext(String name, Map<String, Object> context) {
		Gson gson = new Gson();
		var eventCreator = new EventParser(name, context);

		this.json = gson.toJson(eventCreator);

		this.name = name;
		this.data = context;
	}

	public EventContext(String json) {
		Gson gson = new Gson();
		var rawContext = gson.fromJson(json, EventParser.class);


		this.json = json;
		this.name = rawContext.redis_id;
		this.data = rawContext.event;
	}

	public Map<String, Object> getData() {

		EventParser prs = new Gson().fromJson(this.json, EventParser.class);
		return prs.getEvent();

	}

	public String getName() {
		return this.name;
	}

	public String getJson() {
		return this.json;
	}


	private class EventParser {
		String redis_id;
		Map<String, Object> event;

		public EventParser(String redis_id, Map<String, Object> event) {
			this.redis_id = redis_id;
			this.event = event;
		}

		public String getRedis_id() {
			return redis_id;
		}

		public Map<String, Object> getEvent() {
			return event;
		}
	}

}


