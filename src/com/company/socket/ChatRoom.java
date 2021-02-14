package com.company.socket;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Vector;
import java.util.function.Consumer;

public class ChatRoom {

    private HashMap<String,Socket> clients;

    public ChatRoom(HashMap<String,Socket> clients) {
        System.out.println("chat room created !");
        this.clients = clients;
    }

    synchronized void broadcastMessage(String message,String sender) throws IOException {

        clients.forEach((clientName,client) -> {
            try{

                if(!clientName.equals(Thread.currentThread().getName())){
                    PrintWriter out = new PrintWriter(client.getOutputStream(),true);
                    out.println(sender + " : " +message);
                }

            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        });
    }
}
