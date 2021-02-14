package com.company.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Server {


    public Server(int port) {

        try(
                ServerSocket serverSocket = new ServerSocket(port);
                ){

            System.out.println("Listening for incoming requests ...");

            HashMap<String,Socket> clients = new HashMap();

            int i =0;
            while(clients.size() < 2){
                clients.put("user"+i++,serverSocket.accept());
                System.out.println("Client accepted");
            }

            ChatRoom chatRoom = new ChatRoom(clients);

            clients.forEach((clientName,client) -> {
                new Session(client,clientName,chatRoom);
            });

        }catch(IOException e){
            System.out.println(e.getMessage());
        }


    }

    public static void main(String[] args) {
            new Server(1024);
    }
}
