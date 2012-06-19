package de.CardsAgainstHumanity.Client;

import de.CardsAgainstHumanity.Server.Interfaces.Lobby;
import de.CardsAgainstHumanity.Server.Interfaces.ServerInterface;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import java.util.List;

/**
 *
 * @author Timo
 */
public class Client {
    private ServerInterface server;
    private ClientCallbackImpl callback;
    private Lookup serverLookup;
    private String playerName = "";
    
    public Client(String playerName){
        this.playerName = playerName;
        callback = new ClientCallbackImpl(this);
    }
    
    public void connect(String ip, int port){
        try {
            serverLookup = Simon.createNameLookup(ip, port);
            server = (ServerInterface) serverLookup.lookup("CAH_server");
            System.out.println("System: Successfully connected to server");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void disconnect(){
        serverLookup.release(server);
        System.out.println("System: disconnected");
    }
     
    public void listLobbies(){
        List<String> lobbies = server.getLobbyList();
        System.out.println("------------------------------");
        System.out.println("           Lobbies:           ");
        System.out.println("------------------------------");
        for(String s:lobbies){
            System.out.println(s);
        }
    }
    
    public void connectToLobby(String s){
        Lobby lobby = server.getLobby(s);
        if(lobby != null){
            int status = lobby.registerPlayer(playerName, callback);
            if(status == Lobby.REGISTER_FAILED_LOBBY_FULL){
                System.err.println("System: Lobby full");
            }else if(status == Lobby.REGISTER_FAILED_NAME_ALLREADY_USED){
                System.err.println("System: Playername TestPlayer allready in use");
            }else{
                System.out.println("System: Successfully connected to lobby "+s);
            }
        }else{
            System.err.println("Couldn't find lobby with name "+s);
        }
    }
}
