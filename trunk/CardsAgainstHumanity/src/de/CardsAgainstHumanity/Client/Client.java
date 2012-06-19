package de.CardsAgainstHumanity.Client;

import de.CardsAgainstHumanity.Server.Interfaces.Lobby;
import de.CardsAgainstHumanity.Server.Interfaces.ServerInterface;
import de.CardsAgainstHumanity.Server.Interfaces.SessionInterface;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import java.util.List;

/**
 *
 * @author Timo
 */
public class Client {
    private ServerInterface server;
    private SessionInterface session;
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
        session = server.getSessionForLobby(s, playerName, callback);
        if(session != null){
            
        }
    }
}
