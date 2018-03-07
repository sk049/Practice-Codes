package com.salil.strings;

/**
 * Created by Salil on 20/01/18.
 */
public class StringMisc {

    public static void main (String [] args){

        String b = "lil";
        String a = "Sa";
        String c = "Salil";
        String con = a.concat(b);
        String d = "Salil";
        System.out.println(d==a.concat(b));
        System.out.println(a.concat(b));
        System.out.println(d.equals(a.concat(b)));
        System.out.println(con==a.concat(b));


        String s = new String("a/b/c/d/e/f");
        String [] a1 = s.split("/");
        for (String iterator : a1){
            System.out.println(iterator);
        }
        String[] a2 = s.split("/",3);
        System.out.println("Regex with Limit");
        for(String iterator : a2){
            System.out.println(iterator);
        }

    }

}
