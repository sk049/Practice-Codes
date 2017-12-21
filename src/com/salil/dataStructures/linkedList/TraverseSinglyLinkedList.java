package com.salil.dataStructures.linkedList;

/**
 * Created by Salil on 24/08/17.
 */
public class TraverseSinglyLinkedList {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d){
             this.data =d;
             this.next=null;
        }
    }

    public void printList(){
        Node n = head;
        while (n!= null){
            System.out.print(n.data+"->");
            n=n.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args){
        TraverseSinglyLinkedList list = new TraverseSinglyLinkedList();
        //list.head=null;
        Node first = new Node(1);
        Node second = new Node(2);
        first.next=second;
        Node third = new Node(3);
        second.next=third;
        if(list.head==null){
            list.head=first;
        }
        list.printList();
    }

}
