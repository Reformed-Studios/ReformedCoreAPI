package eu.reformedstudios.reformedcoreapi.commands;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Builder class to create a command instance.
 */
public class CommandBuilder {
	private String name;
	private String usage;
	private List<String> permissions = Collections.emptyList();
	private String description;
	private List<String> aliases = Collections.emptyList();

	/**
	 * Sets the command name (the primary command, i.e. /name would have the name "name".)
	 *
	 * @param name The name you want to pass.
	 * @return The builder for chaining purposes
	 */
	public CommandBuilder setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Sets the command usage, used in f.e. help menu.
	 *
	 * @param usage The usage you want to pass
	 * @return The builder for chaining purposes
	 */
	public CommandBuilder setUsage(String usage) {
		this.usage = usage;
		return this;
	}

	/**
	 * Sets the command permissions, automatically gets checked on execute. If your command uses multiple permissions,
	 * i.e. "command.self", "command.other", add both in here and check individually depending on what the permission
	 * allows them to do. You do <stong>NOT</stong> need to send an error message.
	 *
	 * @param permissions The permissions you want to pass
	 * @return The builder for chaining purposes
	 */
	public CommandBuilder setPermissions(String... permissions) {
		this.permissions = Arrays.asList(permissions);
		return this;
	}

	/**
	 * Sets the command description, used in f.e. help menu.
	 *
	 * @param description The description you want to pass
	 * @return The builder for chaining purposes
	 */
	public CommandBuilder setDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * The aliases the command should have. Automatically work.
	 *
	 * @param aliases The aliases you want to pass
	 * @return The builder for chaining purposes
	 */
	public CommandBuilder setAliases(String... aliases) {
		this.aliases = Arrays.asList(aliases);
		return this;
	}

	/**
	 * Builds the command.
	 *
	 * @return The newly created Command.
	 */
	public Command createCommand() {
		return new Command(name, usage, permissions, description, aliases);
	}
}
