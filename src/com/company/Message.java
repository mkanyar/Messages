package com.company;

class Message {
    private String message;
    private boolean empty = true;

    //one synchronize method can run at a time thus having the read and write methods synchronized will create a deadlock
    public synchronized String read() {
        while(empty) {
           try{
               wait();
           }
           catch(InterruptedException e){

           }
        }
        empty = true;
        //use notifyAll to wake up the threads. In case there are many threads notify is better in order to have better performance
        notifyAll();
        return message;
    }

    public synchronized void write(String message) {
        while(!empty) {
            try{
                //never assume that a thread is woken up because the conditions may have changed that's the reason why we put it on a loop
                wait();
            }
            catch(InterruptedException e){

            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}