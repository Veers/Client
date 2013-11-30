package ru.apache_maven;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


public class MyTextActionListener implements KeyListener {
    Connector connector;
    private JTextField field;
    public MyTextActionListener(Connector conn, JTextField field){
        this.connector = conn;
        this.field = field;
    }

    public String getText(){
        return this.field.getText();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == 10){
             System.out.println(getText());
             // todo
             this.field.setText("");
             try {
                 connector.send(getText());
             } catch (IOException e1) {
                 e1.printStackTrace();
             }
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
