package ru.gbhw.java.Messenger.Client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.SwingUtilities;

public class RunClient extends Thread {
    OutputStream output;
    InputStream input;
    String serverIP, userName, message;
    int serverPort;
    Socket socket;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    RunClient(String serverIP, int port, String user){
        this.serverIP = serverIP;
        this.serverPort = port;
        this.userName = user;
        Client.permission(false);
    }
    @Override
    public void run() {
        try{
            connectToServer();
            setupStreams();
            whileChatting();
        }
        catch(IOException e){
            e.getMessage();
        }
        finally{
            close();
        }
    }
    private void connectToServer() throws UnknownHostException, IOException{
        socket = new Socket(InetAddress.getByName(serverIP), serverPort);
        showMessage("Устанавливается соединение с сервером...");
    }
    private void setupStreams() throws IOException{
        output = new ObjectOutputStream(socket.getOutputStream());
        output.flush();
        input = new ObjectInputStream(socket.getInputStream());
        showMessage("Соединение установлено");
    }
    private void whileChatting()throws IOException {
        do{
            try{
                message = (String)((ObjectInputStream) input).readObject();
                showMessage(message);
            }
            catch(ClassNotFoundException e){

            }
        }while(!message.equals("SERVER: END"));
    }
    public void close(){
        showMessage("Закрытие всех соединений...");
        try{
            if(socket != null){
                output.close();
                input.close();
                socket.close();
            }
            showMessage("Соединения закрыты");
            Client.permission(true);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    private void showMessage(final String m){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                Client.textMessage.append(m + "\n");
            }
        });
    }
    public void sendMessage(String message){
        try{
            ((ObjectOutputStream) output).writeObject(LocalDateTime.now().format(formatter) + " "+ userName + ": " + message);
            output.flush();
        }catch(IOException e){
            
        }
    }
}
