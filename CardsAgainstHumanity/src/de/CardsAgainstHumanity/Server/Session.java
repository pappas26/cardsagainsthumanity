package de.CardsAgainstHumanity.Server;

import de.CardsAgainstHumanity.Client.Interfaces.ClientCallback;
import de.CardsAgainstHumanity.Server.Interfaces.Lobby;
import de.CardsAgainstHumanity.Server.Interfaces.SessionInterface;
import de.root1.simon.SimonUnreferenced;
import de.root1.simon.annotation.SimonRemote;
import java.io.Serializable;

/**
 *
 * @author Timo
 */
@SimonRemote(value = {SessionInterface.class})
public class Session implements SessionInterface,  SimonUnreferenced, Serializable {

    private static int SESSION_ID = 0;
    
    private int id;
    private ClientCallback callback;
    private String user;
    private Lobby lobby;
    
    public Session(String user, ClientCallback callback, Lobby lobby){
        id = SESSION_ID++;
        this.callback = callback;
        this.user = user;
        this.lobby = lobby;
    }
    
    
    @Override
    public void unreferenced() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getSessionID() {
        return id;
    }

    @Override
    public ClientCallback getClientCallback() {
        return callback;
    }

    @Override
    public String getUserName() {
        return user;
    }
}
