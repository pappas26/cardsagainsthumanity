package de.CardsAgainstHumanity.Server.Interfaces;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;

/**
 *
 * @author Timo
 */
public interface SessionInterface {
    
    public int getSessionID();
    
    public ClientCallback getClientCallback();
    
    public String getUserName();
}
