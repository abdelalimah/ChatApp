package com.company.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread extends Thread {

    private Socket clientSocket;
    private PrintWriter out;

    public WriteThread(Socket socket) {
        this.clientSocket = socket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {

                String msg= scanner.nextLine();
                out.println(msg);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
