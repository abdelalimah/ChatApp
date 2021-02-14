package com.company.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Session implements Runnable {

    private Socket clientSocket ;
    private ChatRoom chatRoom;
    private Thread runner;

    public Session(Socket clientSocket,String clientName,ChatRoom chatRoom) {

        this.clientSocket = clientSocket;
        this.chatRoom = chatRoom;
        runner = new Thread(this,clientName);
        runner.setName(clientName);
        runner.start();

    }

    @Override
    public void run() {
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                ){
            while(true){

                String msg = in.readLine();
                chatRoom.broadcastMessage(msg,runner.getName());

            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
