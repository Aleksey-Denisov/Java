package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedList;

public class Server {
    private ServerSocket servSocket;
    public static final LinkedList<Client> clients = new LinkedList<>();

    public Server() {
        try{
            servSocket = new ServerSocket(1234);
            while(!servSocket.isClosed()) {
                clients.add(new Client(servSocket.accept()));
            }
        } catch (IOException e) {
            closeServer();
        }
    }

    public void closeServer() {
        if(servSocket != null) {
            try {
                servSocket.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
        }
    }
}
