package de.CardsAgainstHumanity;

import de.CardsAgainstHumanity.Client.Client;
import de.CardsAgainstHumanity.Server.Errors.LobbyException;
import de.CardsAgainstHumanity.Server.Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException, LobbyException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Cards against Humanity - Test");
        String line = "";
        Server s = null;
        Client c = null;
        while(!(line = console.readLine()).equals("exit")){
            if(line.equals("server")){
                if(s == null){
                    s = new Server();
                }
                if(s.startServer()){
                    System.out.println("System: Server started");
                }
            }else if(line.split(" ")[0].equals("lobby")){
                s.createLobby(line.split(" ")[1], 6);
                System.out.println("System: Lobby with name "+line.split(" ")[1]+" was created");
            }else if(line.equals("stop")){
                if(s != null){
                    s.stopServer();
                    System.out.println("System: Server stopped");
                }
            }else if(line.split(" ")[0].equals("connect")){
                if(c == null){
                    c = new Client(line.split(" ")[1]);
                }
                c.connect(line.split(" ")[2], Integer.valueOf(line.split(" ")[3]));
            }else if(line.equals("disconnect")){
                if(c != null){
                    c.disconnect();
                    c = null;
                }
            }else if(line.equals("list")){
                if(c != null){
                    c.listLobbies();
                }
            }else if(line.split(" ")[0].equals("join")){
                if(c != null){
                    c.connectToLobby(line.split(" ")[1]);
                }
            }
        }
    }
}
