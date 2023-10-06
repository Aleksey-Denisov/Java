package ru.gbhw.java.Messenger.Server;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    public static JTextArea textLogs = new JTextArea();
    JScrollPane scrollLogs = new JScrollPane(textLogs);
    JButton btnStartSrv, btnStopSrv;
    RunServer runServer;

    Server(){
        setTitle("Server Messenger");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        JPanel topBottom = new JPanel(new GridLayout(1,2));
        btnStartSrv = new JButton("Start");
        btnStopSrv = new JButton("Stop");
        topBottom.add(btnStartSrv);
        topBottom.add(btnStopSrv);
        textLogs.setEditable(false);
        add(topBottom, BorderLayout.SOUTH);
        add(scrollLogs);

        btnStartSrv.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                runServer = new RunServer();
                runServer.start();
            }
            
        });
        btnStopSrv.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                runServer.closeConnection();
                runServer.close();
            }
            
        });

        setVisible(true);
    }
}
