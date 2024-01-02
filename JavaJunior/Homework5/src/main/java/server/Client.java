package server;

import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class Client {
    private final Socket socket;
    private BufferedReader input;
    private BufferedWriter output;
    private String name;

    public Client(Socket socket) {
        this.socket = socket;
        System.out.println("Новое соединение " + socket.getInetAddress().getHostName());
        setUpConnections();
        whileChating();
    }

    private void setUpConnections() {
        try{
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = input.readLine();
            if(isNameNotConnected(name)) {
                sendMesasge("~LOGINISBUSY");
            }
            System.out.println("Пользователь " + name);
        } catch (IOException e) {
            closeConnections();
        }
    }

    private void whileChating() {
        new Thread(() -> {
            while(socket.isConnected()) {
                try{
                    messageProc(input.readLine());
                } catch (IOException e) {
                    closeConnections();
                    break;
                }
            }
        }).start();
    }

    private void messageProc(String message) {
        String[] mesSplit = message.split(" ", 3);
        if(mesSplit.length >= 2 && mesSplit[2].startsWith("@")) {
            String[] userData = mesSplit[2].substring(1).split(" ", 2);
            if(isNameNotConnected(userData[0])) {
                Objects.requireNonNull(getClient(userData[0])).sendMesasge(message);
            }
            else
                sendMesasge("Пользователя нет на сервере");
        } else {
            for(Client client : Server.clients) {
                if(!client.getName().equals(name))
                    client.sendMesasge(message);
            }
        }
    }

    private Client getClient(String nameClient) {
        for(Client client : Server.clients) {
            if(client.getName().equals(nameClient))
                return client;
        }
        return null;
    }

    public void sendMesasge(String message) {
        try{
            output.write(message);
            output.newLine();
            output.flush();
        } catch (IOException e) {
            closeConnections();
        }
    }

    public void closeConnections() {
        try{
            if(output != null)
                output.close();
            if(input != null)
                input.close();
            if(socket != null)
                socket.close();
            Server.clients.remove(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    private boolean isNameNotConnected(String nameClient) {
        for(Client client : Server.clients) {
            if(client.getName().equals(nameClient))
                return true;
        }
        return false;
    }

}
