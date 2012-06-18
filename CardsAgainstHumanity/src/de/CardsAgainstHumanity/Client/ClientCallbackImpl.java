package de.CardsAgainstHumanity.Client;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;
import de.root1.simon.annotation.SimonRemote;

/**
 *
 * @author Timo
 */
@SimonRemote(value = {ClientCallback.class})
public class ClientCallbackImpl implements ClientCallback{

    @Override
    public void sendMessage(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendSystemMessage(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void registerInfo(boolean success) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
