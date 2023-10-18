package ru.gbhw.java.client;

import ru.gbhw.java.server.Server;

public class Client {
    private String name;
    private ClientGUI clientGUI;
    private Server server;
    private boolean connected;

    public Client(ClientGUI clientGUI, Server server) {
        this.clientGUI = clientGUI;
        this.server = server;
    }

    public boolean connectToServer(String name){
        this.name = name;
        if (server.connectUser(clientGUI)){
            printText("Вы успешно подключились!\n");
            connected = true;
            String log = server.getHistory();
            if (log != null){
                printText(log);
            }
            return true;
        } else {
            printText("Подключение не удалось");
            return false;
        }
    }

    //мы посылаем
    public void sendMessage(String message){
        if (connected) {
            if (!message.isEmpty()) {
                server.sendMessage(name + ": " + message);
            }
        } else {
            printText("Нет подключения к серверу");
        }
    }
    //нам посылают
    public void serverAnswer(String answer){
        printText(answer);
    }

    public void disconnect(){
        if (connected) {
            connected = false;
            clientGUI.disconnectFromServer();
            server.disconnectUser(clientGUI);
            printText("Вы были отключены от сервера!");
        }
    }

    public String getName() {
        return name;
    }

    private void printText(String text){
        clientGUI.showMessage(text);
    }
}