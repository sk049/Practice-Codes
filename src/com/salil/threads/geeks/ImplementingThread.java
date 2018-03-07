package com.salil.threads.geeks;

/**
 * Created by Salil on 07/02/18.
 */

class MyThreadImpClass implements Runnable{

    @Override
    public void run() {
        System.out.println("Thread"+Thread.currentThread().getId()+"is runing");
    }
}

public class ImplementingThread {

    public static void main(String[] args){
        for (int i =0 ;i<8;i++){
            Thread object = new Thread(new MyThreadImpClass());
            object.start();

        }
        Thread t1 = new Thread(new MyThreadImpClass());
        t1.start();
    }

}
