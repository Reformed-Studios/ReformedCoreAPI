package eu.reformedstudios.reformedcoreapi.commands;


import org.bukkit.command.CommandSender;

/**
 * Class to extend if you are listening for a command.
 */
public abstract class CommandListener {

    Command command;

    /**
     * Constructor to construct the command.
     *
     * @param command Use the {@link eu.reformedstudios.reformedcoreapi.commands.CommandBuilder} to construct.
     */
    public CommandListener(Command command) {
        this.command = command;
    }

    /**
     * Getter for the command instance.
     *
     * @return The command instance.
     */
    public Command getCommand() {
        return command;
    }

    /**
     * Method that gets called on command execution.
     *
     * @param sender {@link org.bukkit.command.CommandSender} that sent the command.
     * @param cmd    {@link org.bukkit.command.Command} instance.
     * @param label  Command name. <strong>This will be automatically checked, only use this if you want to distinguish aliases.</strong>
     * @param args   Array of command arguments.
     * @return True: successful command; nothing happens. False: prints the command usage because Bukkit.
     */
    public boolean exec(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        return false;
    }
}
