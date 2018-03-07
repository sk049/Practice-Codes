package com.salil.threads.demo;

/**
 * Created by Salil on 05/02/18.
 */

class MyClass implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getId()+ "value " + i);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

public class RunnableDemo {

    public static void main(String []args){
        /*Thread t1 = new Thread(new MyClass() );
        Thread t2 = new Thread(new MyClass() );
        t1.start();
        t2.start();*/

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println(Thread.currentThread().getId()+ "value " + i);
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t3.start();
    }

}
