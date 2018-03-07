package com.salil.threads.geeks;

/**
 * Created by Salil on 09/02/18.
 */

// Java code to see that all threads are
// pushed on same stack if we use run()
// instead of start().
class ThreadTest extends Thread
{
    public void run()
    {
        try
        {
            // Displaying the thread that is running
            System.out.println ("Thread " +
                    Thread.currentThread().getId() +
                    " is running");

        }
        catch (Exception e)
        {
            // Throwing an exception
            System.out.println ("Exception is caught");
        }
    }
}

public class DummyThread {
    public static void main(String[] args)
    {
        int n = 8;
        for (int i=0; i<n; i++)
        {
            ThreadTest object = new ThreadTest();

            // start() is replaced with run() for
            // seeing the purpose of start
            //object.start();
            object.run();
        }
    }

}
