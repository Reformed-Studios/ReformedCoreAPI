package eu.reformedstudios.reformedcoreapi.commands;

import java.util.List;

/**
 * Dataclass that represents a command.
 */
public class Command {

    private final String name;
    private final String usage;
    private final List<String> permissions;
    private final String description;
    private final List<String> aliases;

    /**
     * @param name        Command name.
     * @param usage       Command usage.
     * @param permissions Command permissions.
     * @param description Command description.
     * @param aliases     Command aliases.
     * @deprecated Use the {@link eu.reformedstudios.reformedcoreapi.commands.CommandBuilder} class.
     */
    public Command(String name, String usage, List<String> permissions, String description, List<String> aliases) {
        this.name = name;
        this.usage = usage;
        this.permissions = permissions;
        this.description = description;
        this.aliases = aliases;
    }

    /**
     * Gives the command name.
     *
     * @return the command name
     */
    public String getName() {
        return name;
    }

    /**
     * Gives the command usage.
     *
     * @return the command usage.
     */
    public String getUsage() {
        return usage;
    }

    /**
     * Gives the command permissions.
     *
     * @return the command permissions.
     */
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     * Gives the command description.
     *
     * @return The command description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gives the command aliases.
     *
     * @return The command aliases.
     */
    public List<String> getAliases() {
        return aliases;
    }
}
