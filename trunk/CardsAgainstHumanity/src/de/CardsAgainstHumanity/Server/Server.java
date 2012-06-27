package de.CardsAgainstHumanity.Server;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback; 
import de.CardsAgainstHumanity.Server.Errors.LobbyException;
import de.CardsAgainstHumanity.Server.Interfaces.Lobby;
import de.CardsAgainstHumanity.Server.Interfaces.ServerInterface;
import de.root1.simon.Registry;
import de.root1.simon.Simon;
import de.root1.simon.annotation.SimonRemote;
import java.util.*;

/**
 *
 * @author Timo
 */
@SimonRemote(value = {ServerInterface.class})
public class Server implements ServerInterface{

    private static final long serialVersionUID = 1L;
    
    public static final int SERVER_PORT = 25565;
    
    private Map<String,LobbyImpl> lobbyList;
    private Registry registry;
    
    public Server(){
        lobbyList = Collections.synchronizedMap(new HashMap<String,LobbyImpl>());
    }
    
    public boolean startServer(){
        return startServer(SERVER_PORT);
    }
    
    public boolean startServer(int port){
        try {
            registry = Simon.createRegistry(port);
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
    public Session getSessionForLobby(String name, String user, ClientCallback callback){
        if(lobbyList.containsKey(name)){
            Lobby lobby = lobbyList.get(name);
            int status = lobby.canAddPlayer(user);
            if(status == Lobby.REGISTER_FAILED_LOBBY_FULL){
                callback.sendSystemMessage("Lobby "+name+" is full");
            }else if(status == Lobby.REGISTER_FAILED_NAME_ALLREADY_USED){
                callback.sendSystemMessage("Lobby "+name+" allready contains a player with name "+user);
            }else if(status == Lobby.REGISTER_SUCCESS){
                Session s = new Session(user,callback,lobby);
                lobby.addPlayer(s);
                return s;
            }
        }
        return null;
    }
    
    @Override
    public List<String> getLobbyList() {
        return new ArrayList<String>(lobbyList.keySet());
    }
    
}
