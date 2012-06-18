package de.CardsAgainstHumanity.Server;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;
import de.CardsAgainstHumanity.Server.Interfaces.ServerInterface;
import de.root1.simon.Registry;
import de.root1.simon.Simon;
import de.root1.simon.annotation.SimonRemote;
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
    
    private Map<String,ClientCallback> players;
    private boolean serverRunning = false;
    private Registry registry;
    private String serverName = "Cards against Humanity Server";
    
    public Server(){
        players = Collections.synchronizedMap(new HashMap<String,ClientCallback>());
    }
    
    public Server(String serverName){
        this();
        this.serverName = serverName;
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
        registry.unbind("CAH_server");
        registry.stop();
    }
    
    public boolean serverRunning(){
        return serverRunning;
    }
    
    @Override
    public void registerPlayer(String name, ClientCallback callback) {
        if(players.containsKey(name)){
            callback.registerInfo(false);
        }else{
            players.put(name,callback);
            callback.registerInfo(true);
            callback.sendSystemMessage("Welcome to Cards against Humanity.");
        }
    }

    @Override
    public List<String> getPlayerList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
