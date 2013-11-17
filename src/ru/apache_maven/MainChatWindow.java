package ru.apache_maven;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainChatWindow {
    public JFrame mainFrame;
    public MainChatWindow(){
        mainFrame = new JFrame("Application");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(new Dimension(600, 400));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel contactPanel = new JPanel();
        JPanel chatPanel = new JPanel();
        splitPane.add(contactPanel);
        splitPane.add(chatPanel);
        mainFrame.add(splitPane);

        Font font = new Font("Verdana", Font.PLAIN, 11);

        JMenuBar menuBar = new JMenuBar();

        JMenu settingsMenu = new JMenu("Settings");
        settingsMenu.setFont(font);

        JMenuItem itemSettings = new JMenuItem("Settings");
        itemSettings.setFont(font);
        settingsMenu.add(itemSettings);

        settingsMenu.addSeparator();

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setFont(font);
        settingsMenu.add(exitItem);

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuBar.add(settingsMenu);

        mainFrame.setJMenuBar(menuBar);

        //mainFrame.pack();
    }
    public void createAndShowGUI(){
        this.mainFrame.setVisible(true);
    }
}
