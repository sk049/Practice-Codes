package com.salil.examples;

/**
 * Created by Salil on 02/04/18.
 */
import java.text.DecimalFormat;

public class RoundValue
{
    public static void main(String[] args)
    {

        double kilobytes = 0.12056358893738;

        System.out.println("kilobytes : " + kilobytes);

        double newKB = Math.round(kilobytes*100.0)/100.0;
        System.out.println("kilobytes (Math.round) : " + newKB);

        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println("kilobytes (DecimalFormat) : " + df.format(kilobytes));

        double cms1 = +1.85;
        double cms2 = +2.35;
        double cms3 = -0.33;

        double overAllCms = (cms1+cms2+cms3);
        System.out.println(overAllCms);
        double newTemp = Math.round(overAllCms*100.0)/100.0;
        System.out.println(newTemp);
    }
}