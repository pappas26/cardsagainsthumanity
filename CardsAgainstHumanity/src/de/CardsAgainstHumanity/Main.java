package de.CardsAgainstHumanity;

import de.CardsAgainstHumanity.Server.Server;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Server s = new Server();
        if(s.startServer()){
            System.out.println("Server running");
        }
        try {
            Thread.sleep(100000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        s.stopServer();
        System.out.println("Server stop");
    }
}
