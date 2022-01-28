package eu.reformedstudios.reformedcoreapi.commands;


import org.bukkit.command.CommandSender;

public abstract class CommandListener {

	Command command;

	public CommandListener(Command command) {
		this.command = command;
	}

	public Command getCommand() {
		return command;
	}

	public boolean exec(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		return false;
	}
}
