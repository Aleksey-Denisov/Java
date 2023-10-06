package ru.gbhw.java.Messenger.Client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame {
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    public static JTextArea textMessage = new JTextArea();
    JScrollPane scrollMessage = new JScrollPane(textMessage);
    public static JButton btnStartClient, btnStopClient, btnSendMessage;
    public static JTextField fieldIP, fieldPort, fieldUser, fieldMessage;
    public static JPasswordField fieldPass;
    public static JPanel topBottom, centerBottom, panBottom;
    RunClient runClient;
    
    Client(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Client Messenger");

        topBottom = new JPanel(new GridLayout(2,3));
        fieldIP = new JTextField("127.0.0.1");
        fieldPort = new JTextField("1234");
        fieldUser = new JTextField("Ivan Ivanovich");
        fieldPass = new JPasswordField("1234");
        fieldMessage = new JTextField();
        btnStartClient = new JButton("Start");
        btnStopClient = new JButton("Stop");
        btnSendMessage = new JButton("Send");
        textMessage.setEditable(false);

        topBottom.add(fieldIP);
        topBottom.add(fieldPort);
        topBottom.add(new JLabel());
        topBottom.add(fieldUser);
        topBottom.add(fieldPass);
        topBottom.add(btnStartClient);
        add(topBottom, BorderLayout.NORTH);

        centerBottom = new JPanel(new BorderLayout());
        centerBottom.add(scrollMessage);
        add(centerBottom, BorderLayout.CENTER);

        panBottom = new JPanel(new BorderLayout());
        panBottom.add(fieldMessage, BorderLayout.CENTER);
        panBottom.add(btnSendMessage, BorderLayout.EAST);
        add(panBottom, BorderLayout.SOUTH);

        btnStartClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textMessage.setText("");
                runClient = new RunClient(fieldIP.getText(),Integer.parseInt(fieldPort.getText()),fieldUser.getText());
                runClient.start();
            }
        });
        btnStopClient.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                runClient.close();
                
            }
        });
        fieldMessage.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    sendMessage();
                 }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        btnSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        setVisible(true);
        
    }
    public static void permission(boolean entered){
        fieldIP.setEditable(entered);
        fieldPass.setEditable(entered);
        fieldPort.setEditable(entered);
        fieldUser.setEditable(entered);
        if(entered){
            topBottom.remove(btnStopClient);
            topBottom.add(btnStartClient);
        }else{
            topBottom.remove(btnStartClient);
            topBottom.add(btnStopClient);
        }
        topBottom.revalidate();
        topBottom.repaint();
    }

    private void sendMessage(){
        runClient.sendMessage(fieldMessage.getText());
        fieldMessage.setText("");
    }
}
