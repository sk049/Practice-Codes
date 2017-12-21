package com.salil.collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Salil on 11/08/17.
 */
public class TestSort {

    static class Student implements Comparable<Student>{
        int rollno;
        String name;
        int age;
        Student(int rollno,String name,int age){
            this.rollno=rollno;
            this.name=name;
            this.age=age;
        }
        public int compareTo(Student st){
            if(age==st.age)
                return 0;
            else if(age>st.age)
                return 1;
            else
                return -1;
        }
    }

    public static void main(String args[]) {
        ArrayList<Student> st = new ArrayList<Student>();
        st.add(new Student(1, "ABC", 22));
        st.add(new Student(106, "Ajay", 27));
        st.add(new Student(105, "Jai", 21));
        Collections.sort(st);
        for (Student st1 : st) {
            System.out.println(st1.rollno + " " + st1.name + " " + st1.age);
        }
    }

}
