package de.CardsAgainstHumanity.Server;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;
import de.CardsAgainstHumanity.Server.Errors.LobbyException;
import de.CardsAgainstHumanity.Server.Interfaces.Lobby;
import de.CardsAgainstHumanity.Server.Interfaces.ServerInterface;
import de.root1.simon.Registry;
import de.root1.simon.Simon;
import de.root1.simon.annotation.SimonRemote;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 

/**
 *
 * @author Timo
 */
@SimonRemote(value = {ServerInterface.class})
public class Server implements ServerInterface{

    public static final int SERVER_PORT = 25565;
    
    private Map<String,LobbyImpl> lobbyList;
    private Registry registry;
    
    public Server(){
        lobbyList = Collections.synchronizedMap(new HashMap<String,LobbyImpl>());
    }
    
    public boolean startServer(){
        try {
            registry = Simon.createRegistry(SERVER_PORT);
            registry.bind("CAH_server", this);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public void stopServer(){
        if(!lobbyList.isEmpty()){
            for(String s:lobbyList.keySet()){
                LobbyImpl lobby = lobbyList.get(s);
                lobby.notifyShutdown();
            }
        }
        lobbyList.clear();
        registry.unbind("CAH_server");
        registry.stop();
    }
    
    public void createLobby(String name,int playerCount) throws LobbyException{
        if(lobbyList.containsKey(name)){
            throw new LobbyException("Lobby with name "+name+" allready exists!");
        }
        LobbyImpl lobby = new LobbyImpl(name,playerCount);
        lobbyList.put(name, lobby);
    }
    
    public void closeLobby(String name) throws LobbyException{
        if(!lobbyList.containsKey(name)){
            throw new LobbyException("Lobby with name "+name+" does not exist!");
        }
        lobbyList.remove(name);
    }

    @Override
    public Lobby getLobby(String name){
        if(lobbyList.containsKey(name)){
            return lobbyList.get(name);
        }
        return null;
    }
    
    @Override
    public List<String> getLobbyList() {
        return new ArrayList<String>(lobbyList.keySet());
    }
    
}
