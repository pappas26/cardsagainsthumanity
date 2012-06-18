package de.CardsAgainstHumanity.Server.Interfaces;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;
import java.util.List;

/**
 *
 * @author Timo
 */
public interface ServerInterface {
    
    public void registerPlayer(String name, ClientCallback callback);
    
    public List<String> getPlayerList();
}
