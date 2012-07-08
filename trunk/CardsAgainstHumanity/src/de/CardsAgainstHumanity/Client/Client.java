package de.CardsAgainstHumanity.Client;

import de.CardsAgainstHumanity.Client.Gui.MainGUI;
import de.CardsAgainstHumanity.Server.Errors.LobbyException;
import de.CardsAgainstHumanity.Server.Interfaces.Lobby.Gametype;
import de.CardsAgainstHumanity.Server.Interfaces.ServerInterface;
import de.CardsAgainstHumanity.Server.Interfaces.SessionInterface;
import de.CardsAgainstHumanity.Server.Server;
import de.root1.simon.Lookup;
import de.root1.simon.Simon;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 *
 * @author Timo
 */
public class Client {

    public static final String LOOK_AND_FEEL_STYLE_PATH = "style.xml";
    private MainGUI gui;
    private ServerInterface server;
    private SessionInterface session;
    private ClientCallbackImpl callback;
    private Lookup serverLookup;
    private String playerName = "";
    //Serverstuff
    private boolean isServer = false;
    private Server localServer;

    public Client(String playerName) {
        this.playerName = playerName;
        callback = new ClientCallbackImpl(this);
        initGui();
    }

    public boolean hostServer(int port) {
        if (localServer == null) {
            localServer = new Server();
        }
        if (localServer.startServer(port)) {
            isServer = true;
            System.out.println("Server started");
            return true;
        }
        return false;
    }

    public boolean stopServer() {
        if (localServer != null) {
            localServer.stopServer();
            isServer = false;
            System.out.println("Server stopped");
            return true;
        }
        return false;
    }
    
    public boolean createLobby(String name, int playerCount, Gametype gametype){
        try {
            localServer.createLobby(name, playerCount, gametype);
        } catch (LobbyException ex) {
            ex.printStackTrace();
            return false;
        }
        System.out.println("Lobby "+name+" created!");
        return true;
    }
    
    public boolean closeLobby(String name){
        try {
            localServer.closeLobby(name);
        } catch (LobbyException ex) {
            ex.printStackTrace();
            return false;
        }
        System.out.println("Lobby "+name+" closed!");
        return true;
    }

    public boolean isServer() {
        return isServer;
    }

    public void connect(String ip, int port) {
        try {
            serverLookup = Simon.createNameLookup(ip, port);
            server = (ServerInterface) serverLookup.lookup("CAH_server");
            System.out.println("System: Successfully connected to server");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void disconnect() {
        serverLookup.release(server);
        System.out.println("System: disconnected");
    }

    public void listLobbies() {
        List<String> lobbies = server.getLobbyList();
        System.out.println("------------------------------");
        System.out.println("           Lobbies:           ");
        System.out.println("------------------------------");
        for (String s : lobbies) {
            System.out.println(s);
        }
    }

    public void connectToLobby(String s) {
        session = server.getSessionForLobby(s, playerName, callback);
        if (session != null) {
        }
    }

    private void initGui() {
        SynthLookAndFeel synth = new SynthLookAndFeel();
        try {
            synth.load(Client.class.getClassLoader().getResource(LOOK_AND_FEEL_STYLE_PATH));
            UIManager.setLookAndFeel(synth);
        } catch (Exception ex) {
            System.out.println("Error in INIT GUI");
            System.exit(1);
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                gui = new MainGUI();
                gui.setTitle("Cards Against Humanity");
                gui.setLocationRelativeTo(null);
                gui.setVisible(true);
            }
        });
    }
}
