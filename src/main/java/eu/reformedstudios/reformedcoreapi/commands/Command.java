package eu.reformedstudios.reformedcoreapi.commands;

import java.util.List;

public class Command {

	private final String name;
	private final String usage;
	private final List<String> permissions;
	private final String description;
	private final List<String> aliases;

	public Command(String name, String usage, List<String> permissions, String description, List<String> aliases) {
			this.name = name;
			this.usage = usage;
			this.permissions = permissions;
			this.description = description;
			this.aliases = aliases;
	}

	public String getName() {
		return name;
	}

	public String getUsage() {
		return usage;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getAliases() {
		return aliases;
	}
}
