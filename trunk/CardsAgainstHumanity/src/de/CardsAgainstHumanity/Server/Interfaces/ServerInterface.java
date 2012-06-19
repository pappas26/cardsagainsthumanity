package de.CardsAgainstHumanity.Server.Interfaces;

import java.util.List;

/**
 *
 * @author Timo
 */
public interface ServerInterface {
    
    public Lobby getLobby(String name);
    
    public List<String> getLobbyList();
}
