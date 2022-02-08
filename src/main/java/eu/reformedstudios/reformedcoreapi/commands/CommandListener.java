package eu.reformedstudios.reformedcoreapi.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Class to extend if you are listening for a command.
 */
public abstract class CommandListener {

    Command command;

    public CommandListener(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public boolean exec(CommandSender sender, Command cmd, String label, String[] args) {
        return false;
    }
}
