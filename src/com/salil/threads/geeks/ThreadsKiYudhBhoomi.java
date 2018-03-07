package com.salil.threads.geeks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salil on 12/02/18.
 */

class Line
{
    // if multiple threads(trains) will try to
    // access this unsynchronized method,
    // they all will get it. So there is chance
    // that Object's  state will be corrupted.
    synchronized public void getLine()
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println(i);
            try
            {
                Thread.sleep(400);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}

class Train extends Thread
{
    // reference to Line's Object.
    Line line;

    Train(Line line)
    {
        this.line = line;
    }

    @Override
    public void run()
    {
        line.getLine();
    }
}




class Geek
{
    String name = "";
    public int count = 0;

    public void geekName(String geek, List<String> list)
    {
        // Only one thread is permitted
        // to change geek's name at a time.
        synchronized(this)
        {
            name = geek;
            count++;  // how many threads change geek's name.
        }

        // All other threads are permitted
        // to add geek name into list.
        list.add(geek);
    }
}


class ThreadsKiYudhBhoomi
{
    public static void main(String[] args)
    {
        // Object of Line class that is shared
       /* // among the threads.
        Line obj = new Line();

        // creating the threads that are
        // sharing the same Object.
        Train train1 = new Train(obj);
        Train train2 = new Train(obj);

        // threads start their execution.
        train1.start();
        train2.start();
*/

            Geek gk = new Geek();
            List<String> list = new ArrayList<String>();
            gk.geekName("mohit", list);
            System.out.println(gk.name);



    }
}

