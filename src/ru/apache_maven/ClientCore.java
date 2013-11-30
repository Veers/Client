package ru.apache_maven;


import javax.swing.*;

public class ClientCore {
    private String address;
    private int port;
    public final Connector connector;

    public ClientCore(){
        System.out.println("Default Constructor");
        connector = new Connector();
        MainChatWindow mainChatWindow = new MainChatWindow(connector);
        mainChatWindow.createAndShowGUI();
        //todo
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientCore();
            }
        });
    }
}
