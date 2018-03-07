package com.salil.threads.geeks;

/**
 * Created by Salil on 15/02/18.
 */

/* Java Program to demonstrate how to use CountDownLatch,
   Its used when a thread needs to wait for other threads
   before starting its work. */
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo
{
    public static void main(String args[]) throws InterruptedException
    {

        CountDownLatch latch = new CountDownLatch(3);

        Waiter      waiter      = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter)     .start();
        new Thread(decrementer).start();

        Thread.sleep(4000);




        /*
        // Let us create task that is going to wait for four
        // threads before it starts
        CountDownLatch latch = new CountDownLatch(4);

        // Let us create four worker threads and start them.
        Worker first = new Worker(1000, latch, "WORKER-1");
        Worker second = new Worker(1000, latch, "WORKER-2");
        Worker third = new Worker(1000, latch, "WORKER-3");
        Worker fourth = new Worker(1000, latch, "WORKER-4");
        Worker fifth = new Worker(1000, latch, "WORKER-5");
        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();

        // The main task waits for four threads
        latch.await();

        // Main thread has started
        System.out.println(Thread.currentThread().getName() +
                " has finished");*/
    }
}


class Waiter implements Runnable{

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }
}


class Decrementer implements Runnable {

    CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {

        try {
            Thread.sleep(1000);
            this.latch.countDown();

            Thread.sleep(1000);
            this.latch.countDown();

            Thread.sleep(1000);
            this.latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// A class to represent threads for which the main thread
// waits.
class Worker extends Thread
{
    private int delay;
    private CountDownLatch latch;

    public Worker(int delay, CountDownLatch latch,
                  String name)
    {
        super(name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()
                    + " finished");
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
