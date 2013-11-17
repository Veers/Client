package ru.apache_maven;


import javax.swing.*;

public class ClientCore {
    public ClientCore(){
        System.out.println("Default Constructor");
        //todo
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientCore();
                MainChatWindow mainChatWindow = new MainChatWindow();
                mainChatWindow.createAndShowGUI();
            }
        });
    }
}
