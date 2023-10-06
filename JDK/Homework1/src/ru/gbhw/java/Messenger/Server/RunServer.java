package ru.gbhw.java.Messenger.Server;

import java.io.*;
import java.net.*;
import java.util.*;

public class RunServer extends Thread {
    private ServerSocket server = null;
    private Socket connection = null;
    private final int PORT = 1234;
    public static LinkedList<ServerSomthing> listConection = new LinkedList<>();

    @Override
    public void run() {
        try{
            server = new ServerSocket(PORT);
            showMessage("Сервер запущен!");
            while(true){
                try{
                    connection = server.accept();
                    listConection.add(new ServerSomthing(connection));
                }catch(IOException ex){
                    connection.close();
                }
            }
        }catch(IOException e){
            e.getMessage();
        }
        finally{
            close();
        }
    }

    public void closeConnection(){
        for(ServerSomthing ss : listConection){
            ss.close();
        }
    }
    public void close(){
        try{
            server.close();
        }
        catch(IOException e){
            e.getMessage();
        }
    }
    public static void showMessage(String message){
        Server.textLogs.append(message + "\n");
    }
}
