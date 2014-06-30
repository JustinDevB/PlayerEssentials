package jjbat_000.playeressentials.mondocommand;

import jjbat_000.playeressentials.mondocommand.CallInfo;
import jjbat_000.playeressentials.mondocommand.MondoFailure;

/**
 * Interface for implementing sub command handlers.
 *
 * @author James Crasta
 */
public interface SubHandler {
    /**
     * Handle a call from a SubCommand.
     * <p/>
     * <p>The passed in call has a number of properties, including the Player
     * (if applicable), CommandSender, information on the SubCommand, and
     * any additional arguments passed.
     * <p/>
     * <p>If the handler throws a {@link MondoFailure}, then the failure's message is
     * printed to the command sender.
     *
     * @param call Contains all the information about the call.
     * @throws MondoFailure An optional error trap mechanism to display errors.
     */
    public void handle(CallInfo call) throws MondoFailure;
}
