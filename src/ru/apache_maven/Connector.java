package ru.apache_maven;


import java.io.*;
import java.net.Socket;

public class Connector extends Thread {
    public  ObjectOutputStream oos;
    public ObjectInputStream inputStream;
    public Connector() {
        System.out.println("Welcome to Client side");
        Socket fromserver = null;
        try {
            fromserver = new Socket("localhost", 4444);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            assert fromserver != null;
            oos = new ObjectOutputStream(
                    fromserver.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            while (true) {
//                BufferedReader br = new BufferedReader(new InputStreamReader(
//                        System.in));
//                String line = br.readLine();
//
//                if (line.equals("exit"))
//                    System.exit(1);
//                String str1 = line.substring(0, line.indexOf(' '));
//                String str2 = line.substring(line.indexOf(' '));
//
//                assert oos != null;
//                oos.writeObject(new Message(str1, str2));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        try {
//            assert oos != null;
//            oos.close();
//            fromserver.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void send(String str) throws IOException {
        oos.writeObject(new Message(str));
        oos.flush();
    }
    public void run(){

    }
}
