package eu.reformedstudios.reformedcoreapi.commands;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CommandBuilder {
	private String name;
	private String usage;
	private List<String> permissions = Collections.emptyList();
	private String description;
	private List<String> aliases = Collections.emptyList();

	public CommandBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public CommandBuilder setUsage(String usage) {
		this.usage = usage;
		return this;
	}

	public CommandBuilder setPermissions(String ... permissions) {
		this.permissions = Arrays.asList(permissions);
		return this;
	}

	public CommandBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	public CommandBuilder setAliases(String ... aliases) {
		this.aliases = Arrays.asList(aliases);
		return this;
	}

	public Command createCommand() {
		return new Command(name, usage, permissions, description, aliases);
	}
}