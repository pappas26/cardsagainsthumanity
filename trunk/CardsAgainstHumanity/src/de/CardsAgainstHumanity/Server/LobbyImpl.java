package de.CardsAgainstHumanity.Server;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;
import de.CardsAgainstHumanity.Server.Interfaces.Lobby;
import de.CardsAgainstHumanity.Server.Interfaces.SessionInterface;
import de.root1.simon.annotation.SimonRemote;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Timo
 */
@SimonRemote(value = {Lobby.class})
public class LobbyImpl implements Lobby{

    private static final long serialVersionUID = 1L;
    
    public static enum Gametype{
        STANDARD;
    }
    
    private String lobbyName = "Cards against Humanity Lobby";
    private List<SessionInterface> playerList;
    private int maxPlayers;
    
    public LobbyImpl(String name, int playerCount){
        this();
        maxPlayers = playerCount;
    }
    
    public LobbyImpl(){
        playerList = Collections.synchronizedList(new ArrayList<SessionInterface>());
    }

    
    public void notifyShutdown(){
        for(SessionInterface s: playerList){
            ClientCallback callback = s.getClientCallback();
            callback.sendSystemMessage("Server shutdown.");
            callback.disconnect();
        }
    }
    
    public void disconnectPlayer(String name){
        SessionInterface del = null;
        for(SessionInterface s:playerList){
            if(s.getUserName().equals(name)){
                s.getClientCallback().sendSystemMessage("Disconnected");
                s.getClientCallback().disconnect();
                del = s;
            }
        }
        if(del != null){
            for(SessionInterface s:playerList){
                s.getClientCallback().sendMessage(del.getUserName()+" disconnected from the Lobby.");
            }
            playerList.remove(del);
        }
    }
    
    @Override
    public void addPlayer(SessionInterface newSession) {
        playerList.add(newSession);
        for(SessionInterface s:playerList){
            s.getClientCallback().sendMessage(newSession.getUserName()+" joined the Lobby");
        }
    }

    @Override
    public void removePlayer(SessionInterface session) {
        playerList.remove(session);
    }
    
    @Override
    public int canAddPlayer(String name) {
        if(playerList.size() >= maxPlayers){
            return Lobby.REGISTER_FAILED_LOBBY_FULL;
        }
        for(SessionInterface s:playerList){
            if(s.getUserName().equals(name)){
                return Lobby.REGISTER_FAILED_NAME_ALLREADY_USED;
            }
        }
        return Lobby.REGISTER_SUCCESS;
    }
    
    @Override
    public List<String> getPlayers(){
        return null;
    }
    
    @Override
    public Lobby.Gametype getGametype(){
        return Lobby.Gametype.STANDARD;
    }
    
    @Override
    public String getLobbyName(){
        return lobbyName;
    }
}
