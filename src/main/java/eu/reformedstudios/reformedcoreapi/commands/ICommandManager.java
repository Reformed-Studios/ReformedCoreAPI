package eu.reformedstudios.reformedcoreapi.commands;

import net.kyori.adventure.text.Component;
import org.bukkit.permissions.Permissible;

/**
 * Interface retrieved by calling ReformedModule#getCommandManager() for registering commands <br />
 * Also has a few helper methods to ease getting a help menu.
 */
public interface ICommandManager {

    /**
     * Method used to register a command.
     *
     * @param listener Listener to register.
     */
    void registerCommand(CommandListener listener);

    /**
     * Method to get the help menu for all commands.
     *
     * @param permissible Permissible interface (player). This makes RC check wether the player has the permission to
     *                    access a command, and doesn't show it to the player if they don't.
     * @return The help menu component.
     */
    Component getHelpMenu(Permissible permissible);

    /**
     * Method to get the help menu for a command query.
     *
     * @param permissible Permissible interface (player). This makes RC check wether the player has the permission to
     *                    access a command, and doesn't show it to the player if they don't.
     * @param commandName Command query.
     * @return The help menu component.
     */
    Component getHelpMenu(Permissible permissible, String commandName);

}
