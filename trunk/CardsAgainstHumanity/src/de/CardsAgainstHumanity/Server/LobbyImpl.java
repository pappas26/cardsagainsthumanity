package de.CardsAgainstHumanity.Server;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;
import de.CardsAgainstHumanity.Server.Interfaces.Lobby;
import de.root1.simon.annotation.SimonRemote;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Timo
 */
@SimonRemote(value = {Lobby.class})
public class LobbyImpl implements Lobby{

    
    public static enum Gametype{
        STANDARD;
    }
    
    private String lobbyName = "Cards against Humanity Lobby";
    private Map<String,ClientCallback> playerMap;
    private int maxPlayers;
    
    public LobbyImpl(String name, int playerCount){
        this();
        maxPlayers = playerCount;
    }
    
    public LobbyImpl(){
        playerMap = Collections.synchronizedMap(new HashMap<String,ClientCallback>());
    }

    
    public void notifyShutdown(){
        for(String s: playerMap.keySet()){
            ClientCallback callback = playerMap.get(s);
            callback.sendSystemMessage("Server shutdown.");
            callback.disconnect();
        }
    }
    
    public void disconnectPlayer(String name){
        if(!playerMap.containsKey(name)){
            System.out.println("Player with "+name+" does not exist.");
            return;
        }
        playerMap.get(name).disconnect();
        playerMap.remove(name);
    }
    
    @Override
    public int registerPlayer(String name, ClientCallback callback) {
        if(playerMap.size() >= maxPlayers){
            return Lobby.REGISTER_FAILED_LOBBY_FULL;
        }else if(playerMap.containsKey(name)){
            return Lobby.REGISTER_FAILED_NAME_ALLREADY_USED;
        }
        System.out.println("LOBBY ["+lobbyName+"]: "+name+" joined the lobby!");
        callback.sendMessage("Welcome to the lobby "+lobbyName);
        playerMap.put(name, callback);
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
