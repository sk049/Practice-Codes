package com.salil.examples;

/**
 * Created by B0097044 on 14/02/18.
 */
public class B extends A {

    B(int a){
        super();
        System.out.println(a);
    }

    public static void main(String[] args){
        B object = new B(2);
    }
}
