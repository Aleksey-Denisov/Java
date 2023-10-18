package ru.gbhw.java.server;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import ru.gbhw.java.client.ClientGUI;
//JDK/Homework2/src/ru/gbhw/java/server/

public class Server {
    public static final String LOG_PATH = "JDK/Homework2/src/ru/gbhw/java/server/log.txt";

    List<ClientGUI> clientGUIList;
    boolean work;
    ServerGUI serverGUI;


    public Server(ServerGUI serverGUI){
        this.serverGUI = serverGUI;
        clientGUIList = new ArrayList<>();
    }

    public void startServer(){
        if (work){
            serverGUI.appendLog("Сервер уже был запущен");
        } else {
            work = true;
            serverGUI.appendLog("Сервер запущен!");
        }
    }
    public void stopServer(){
        if (!work){
            serverGUI.appendLog("Сервер уже был остановлен");
        } else {
            work = false;
            for (ClientGUI clientGUI: clientGUIList){
                disconnectUser(clientGUI);
            }
            clientGUIList.removeAll(clientGUIList);
            serverGUI.appendLog("Сервер остановлен!");
        }
    }
    public boolean connectUser(ClientGUI clientGUI){
        if (!work){
            return false;
        }
        clientGUIList.add(clientGUI);
        return true;
    }
    public String getHistory() {
        return readLog();
    }
    public void disconnectUser(ClientGUI clientGUI){
        clientGUIList.remove(clientGUI);
        if (clientGUI != null){
            clientGUI.disconnectFromServer();
        }
    }
    public void sendMessage(String text){
        if (!work){
            return;
        }
//        text += "";
        serverGUI.appendLog(text);
        answerAll(text);
        saveInLog(text);
    }
    private void answerAll(String text){
        for (ClientGUI clientGUI: clientGUIList){
            clientGUI.answer(text);
        }
    }

    private void saveInLog(String text){
        try (FileWriter writer = new FileWriter(LOG_PATH, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String readLog(){
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);){
            int c;
            while ((c = reader.read()) != -1){
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length()-1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e){
            System.out.println("Файла не существует");
            return null;
        }
    }
}
