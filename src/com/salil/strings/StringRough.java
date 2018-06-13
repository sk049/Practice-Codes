package com.salil.strings;

/**
 * Created by Salil on 09/03/18.
 */
public class StringRough {

    public static void main(String[] args){
        String str = new String("Hello");
        StringBuilder builder = new StringBuilder("Hello");
        StringBuffer buffer = new StringBuffer("Hello");

        str.concat(" Hi.....");
        builder.append(" Hi.......");
        buffer.append(" Hi.......");

        System.out.println(str);        //a
        System.out.println(builder);    //b
        System.out.println(buffer);     //c

        String str1 = new String("Hello");
        String str2 = new String("Hello");
        String temp = new String(" hi");


        System.out.println(str1 == str2);        //d
        System.out.println(str1.equals(str2));   //e
        System.out.println(str1+temp);           //f
        String temp4 = "Hello hi";
        String temp3 = str1.concat(temp);
        System.out.println(temp3==temp4);        //g


    }

}
