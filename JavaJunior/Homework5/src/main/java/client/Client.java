package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Client {
    private BufferedReader input;
    private BufferedWriter output;
    private Socket socket;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
    private final String login;

    public Client(String login) {
        this.login = login;
        setUpConnections();
        whileChating();
    }

    private void setUpConnections() {
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 1234);
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            output.write(login);
            output.newLine();
            output.flush();
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            closeConnections();
        }
    }

    private void whileChating() {
        new Thread(() -> {
            while(socket.isConnected()) {
                try {
                    showMessage(input.readLine());
                } catch (IOException e) {
                    closeConnections();
                    break;
                }
            }
        }).start();
    }

    private void showMessage(String message) {
        if(message.equals("~LOGINISBUSY")) {
            System.out.println("Указанный логин занят другим пользователем, попробуйте снова!");
            closeConnections();
            System.exit(0);
        } else {
            System.out.println(message);
        }
    }

    public void closeConnections() {
        try {
            if(output != null)
                output.close();
            if(input != null)
                input.close();
            if(socket != null)
                socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMesasge() {
        Scanner scanner = new Scanner(System.in);
        while(socket.isConnected()) {
            try {
                String message = scanner.nextLine();
                if(!message.equals("")) {
                    output.write(LocalDateTime.now().format(formatter) + " " + login + " " + message);
                    output.newLine();
                    output.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                closeConnections();
            }
        }
    }
}
