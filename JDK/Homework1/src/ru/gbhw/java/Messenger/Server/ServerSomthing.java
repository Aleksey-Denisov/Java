package ru.gbhw.java.Messenger.Server;

import java.io.*;
import java.net.*;


public class ServerSomthing extends Thread {
    ObjectOutputStream output = null;
    ObjectInputStream input = null;
    ActionFile actionFile = new ActionFile();
    Socket socket;
    
    ServerSomthing(Socket socket) throws IOException{
        this.socket = socket;
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        RunServer.showMessage("Новое соединение " + socket.getInetAddress().getHostName());
        getHistory();
        start();
    }

    @Override
    public void run(){
        String message;
        try{
            while(true){
                message = (String) input.readObject();
                actionFile.writeToFile(message);
                RunServer.showMessage(message);
                for(ServerSomthing ss : RunServer.listConection){
                    ss.send(message);
                }
            }
        }
        catch (IOException | ClassNotFoundException e) {
            e.getMessage();
        }
    }
    private void getHistory() {
        try{
            String histMessage = actionFile.readFile();
            if(histMessage != null){
                output.writeObject(histMessage);
                output.flush();
            }
        }
        catch(IOException ignored){}
    }
    private void send(String message) {
        System.out.println(message);
        try{
            output.writeObject(message);
            output.flush();
        }
        catch(IOException ignored){}
    }

    public void close() {
        try{
            RunServer.showMessage("Отключение клиента: " + socket.getInetAddress().getHostName());
            output.close();
            input.close();
            socket.close();
        }
        catch(IOException e){
            e.getMessage();
        }
    }
}
