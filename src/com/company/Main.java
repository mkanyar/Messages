package com.company;





public class Main {

    public static void main(String[] args) {
        Message message=new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader (message))).start();
    }
}



