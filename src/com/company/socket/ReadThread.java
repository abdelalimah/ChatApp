package com.company.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

public class ReadThread extends Thread {

    private Socket clientSocket;
    private BufferedReader in;

    public ReadThread(Socket socket) {

        this.clientSocket = socket;
        try{
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {

        while (true) {

            try {

                String receivedMsg = in.readLine();

                if(receivedMsg != null){
                    System.out.println(receivedMsg);
                }

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
