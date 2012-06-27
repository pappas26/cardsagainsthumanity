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
        SessionInterface del = getPlayerSession(name);
        if(del != null){
            del.getClientCallback().sendSystemMessage("Disconnected");
            del.getClientCallback().disconnect();
            playerList.remove(del);
            broadcastMessage(del.getUserName()+" disconnected from the Lobby.");
        }
    }
    
    private SessionInterface getPlayerSession(String name){
        for(SessionInterface s:playerList){
            if(s.getUserName().equals(name)){
                return s;
            }
        }
        return null;
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
        if(getPlayerSession(name) != null){
            return Lobby.REGISTER_FAILED_NAME_ALLREADY_USED;
        }
        return Lobby.REGISTER_SUCCESS;
    }
    
    @Override
    public void sendMessageToPlayer(String name, String message){
        SessionInterface s = getPlayerSession(name);
        if(s != null){
            s.getClientCallback().sendMessage(message);
        }
    }
    
    @Override
    public void broadcastMessage(String msg){
        for(SessionInterface s:playerList){
            s.getClientCallback().sendMessage(msg);
        }
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
    

    @Override
    public void startGame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void stopGame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isGameRunning() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
