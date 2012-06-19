package de.CardsAgainstHumanity.Server.Interfaces;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;
import java.util.List;

/**
 *
 * @author Timo
 */
public interface ServerInterface {
    
    public SessionInterface getSessionForLobby(String name, String user, ClientCallback callback);
    
    public List<String> getLobbyList();
}
