package com.company.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;


    public Client(String addr,int port) {
        try{
                socket = new Socket(addr,port);

                WriteThread writeThread = new WriteThread(socket);
                ReadThread readThread = new ReadThread(socket);

                writeThread.start();
                readThread.start();


        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        new Client("127.0.0.1",1024);
    }
}
