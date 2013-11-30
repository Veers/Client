package ru.apache_maven;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainChatWindow {
    public JFrame mainFrame;
    Connector connector;
    public MainChatWindow(Connector connector){
        this.connector = connector;
        mainFrame = new JFrame("Application");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(new Dimension(600, 400));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel contactPanel = new JPanel();
        splitPane.add(contactPanel);
        splitPane.add(packChatPanel());
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

        JPanel statusPanel = new JPanel();
        statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        mainFrame.add(statusPanel, BorderLayout.SOUTH);
        statusPanel.setPreferredSize(new Dimension(mainFrame.getWidth(), 16));
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel("status");
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);

        //mainFrame.pack();
    }

    public JPanel packChatPanel(){
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());
        JTextArea history = new JTextArea();
        JTextField input = new JTextField(30);
        input.addKeyListener(new MyTextActionListener(connector, input));
        history.setEditable(false);
        chatPanel.add(history);
        chatPanel.add(input, BorderLayout.SOUTH);
        return chatPanel;
    }
    public void createAndShowGUI(){
        this.mainFrame.setVisible(true);
    }
}
