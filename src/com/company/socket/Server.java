package com.company.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public Server(int port) {

        try(
                ServerSocket serverSocket = new ServerSocket(port);
                ){

            System.out.println("Listening for incoming requests ...");

            ChatRoom chatRoom = new ChatRoom();

            int i = 0;
            int clientCount = 0;
            while(clientCount < 2){
                Socket socket = serverSocket.accept();
                clientCount++;
                String clientName = "Client no"+i++;
                System.out.println("Client accepted");
                new Session(socket,clientName,chatRoom);
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }


    }

    public static void main(String[] args) {
            new Server(1024);
    }
}
