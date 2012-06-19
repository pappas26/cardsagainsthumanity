package de.CardsAgainstHumanity.Server.Interfaces;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;
import java.util.List;

/**
 *
 * @author Timo
 */
public interface Lobby {
    
    public static int REGISTER_SUCCESS = 0;
    public static int REGISTER_FAILED_NAME_ALLREADY_USED = 1;
    public static int REGISTER_FAILED_LOBBY_FULL = 2;
    
    public static enum Gametype{
        STANDARD;
    }
    
    /**
     * Returns an integer representing the success of the registering!
     * Can return
     *  REGISTER_SUCCESS = 0
     *  REGISTER_FAILED_NAME_ALLREADY_USED = 1
     *  REGISTER_FAILED_LOBBY_FULL = 2;
     * 
     * @param name
     * @param callback
     * @return 
     */
    public int canAddPlayer(String name);
    
    public void addPlayer(SessionInterface session);
    
    public void removePlayer(SessionInterface session);
    
    public List<String> getPlayers();
    
    public Gametype getGametype();
    
    public String getLobbyName();
}
