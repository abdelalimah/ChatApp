package com.company.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public Client(String addr,int port) {
        try(
                    Socket socket = new Socket(addr,port);
                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());
                ){

            Scanner scanner = new Scanner(System.in);

            while(true){

                String msg = scanner.nextLine();

                output.writeUTF(msg);
                //String receivedMsg = input.readUTF();

                //System.out.println("server echoed message : "+receivedMsg);
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Client("127.0.0.1",1024);
    }
}
