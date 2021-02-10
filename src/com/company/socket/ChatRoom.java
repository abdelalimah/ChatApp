package com.company.socket;

public class ChatRoom {

    void broadcastMessage(String message){
        System.out.println(Thread.currentThread().getName()+" : "+message);
    }
}
