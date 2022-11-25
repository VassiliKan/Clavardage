package org.example;

import org.example.NetworkManager.SendUDP;
import org.example.NetworkManager.ReceiveUDP;

import java.net.SocketException;
import java.net.UnknownHostException;

public class Main2 {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                SendUDP c;
                try {
                    c = new SendUDP(4443);
                    c.start();
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
            }
        });


        ReceiveUDP serv;
        String echo;

        try {
            serv = new ReceiveUDP(4444);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        serv.start();

        t.start();

    }
}