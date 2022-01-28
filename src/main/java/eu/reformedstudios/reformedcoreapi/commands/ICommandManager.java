package eu.reformedstudios.reformedcoreapi.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.permissions.Permissible;

public interface ICommandManager {

	void registerCommand(CommandListener l);

	Component getHelpMenu(Permissible p);

	Component getHelpMenu(Permissible p, String commandName);


}
