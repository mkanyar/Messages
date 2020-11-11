package com.company;

class Message {
    private String message;
    private boolean empty = true;

    //one synchronize method can run at a time thus having the read and write methods synchronized will create a deadlock
    public synchronized String read() {
        while(empty) {

        }
        empty = true;
        return message;
    }

    public synchronized void write(String message) {
        while(!empty) {

        }
        empty = false;
        this.message = message;
    }
}