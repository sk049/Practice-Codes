package com.salil.examples;

import java.util.Random;

/**
 * Created by Salil on 02/04/18.
 */
public class RandomNumbers {

    public static void main(String [] args){
        Random rand = new Random();
        float max = (float) 1.00;
        float min = (float) 0.25;
        float result = rand.nextFloat() * (max - min) + min;
        System.out.println(result);

        float result1 = rand.nextFloat() * (max - min) + min;
        System.out.println(result1);

        float result2 = rand.nextFloat() * (max - min) + min;
        System.out.println(result2);

        System.out.println(Math.round(result*100)/100);

        double res = (Math.random() * ((max - min))) + min;
        System.out.println(res);

        System.out.println( (float) (Math.random() * ((max - min) ) + min));
        System.out.println((Math.round((Math.random() * ((max - min) )) + min)*100.0)/100.0  );
        System.out.println((Math.random() * ((max - min) )) + min);
        System.out.println((Math.random() * ((max - min) )) + min);
    }
}
