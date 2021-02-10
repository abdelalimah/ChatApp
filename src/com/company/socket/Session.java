package com.company.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                ){
            while(true){
                String msg = in.readUTF();
                chatRoom.broadcastMessage(msg);
                //out.writeUTF(msg);
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
