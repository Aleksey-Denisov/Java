package ru.gbhw.java;

import ru.gbhw.java.client.ClientGUI;
import ru.gbhw.java.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        ServerGUI serverGUI = new ServerGUI();
        new ClientGUI(serverGUI);
        new ClientGUI(serverGUI);
    }
}
