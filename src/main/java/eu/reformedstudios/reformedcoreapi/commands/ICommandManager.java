package eu.reformedstudios.reformedcoreapi.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.permissions.Permissible;

/**
 * Interface retrieved by calling ReformedModule#getCommandManager() for registering commands <br />
 * Also has a few helper methods to ease getting a help menu.
 */
public interface ICommandManager {

    void registerCommand(CommandListener l);

    Component getHelpMenu(Permissible p);

    Component getHelpMenu(Permissible p, String commandName);

}
