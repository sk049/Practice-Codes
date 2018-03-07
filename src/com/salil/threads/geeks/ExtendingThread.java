package com.salil.threads.geeks;

/**
 * Created by Salil on 07/02/18.
 */

class MyThreadClass extends Thread{

    public void run(){
        System.out.println("Thraed"+Thread.currentThread().getId()+"is runing");
    }
}

public class ExtendingThread {

    public static void main(String [] args){
        for(int i=0;i<8;i++){
            MyThreadClass myThreadClass = new MyThreadClass();
            myThreadClass.start();
        }
    }

}
