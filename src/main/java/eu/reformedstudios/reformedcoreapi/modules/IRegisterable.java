package eu.reformedstudios.reformedcoreapi.modules;

import eu.reformedstudios.reformedcoreapi.commands.ICommandManager;
import eu.reformedstudios.reformedcoreapi.events.EventContext;
import eu.reformedstudios.reformedcoreapi.events.IEventListener;

import java.util.List;

/**
 * Internal interface for managing API -> impl communication.
 */
public interface IRegisterable {

    /**
     * Registers ReformedModules.
     *
     * @param modules The {@link eu.reformedstudios.reformedcoreapi.modules.ReformedModule} to register.
     */
    void addModules(List<ReformedModule> modules);

    /**
     * Executes an event.
     *
     * @param ctx The {@link eu.reformedstudios.reformedcoreapi.events.EventContext} from the event.
     */
    void runEvent(EventContext ctx);

    /**
     * Returns the {@link eu.reformedstudios.reformedcoreapi.commands.ICommandManager} for your specific module.
     *
     * @param module The module that you need the commandManager from.
     * @return The command manager.
     */
    ICommandManager getCommandManager(ReformedModule module);

    /**
     * Registers an event listener.
     *
     * @param listener The listener you want to register.
     */
    void registerListener(IEventListener listener);


}
