package com.salil.dataStructures.linkedList;

/**
 * Created by Salil on 24/08/17.
 */

public class LinkedList{
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int d){
            this.data=d;
            this.next=null;
        }
    }

    public void insertAtStart(int data){
        Node new_node = new Node(data);
        if(head == null){
            head=new_node;
        }
        else{
            new_node.next=head;
            head=new_node;
        }
    }

    public void append(int data){
        Node temp = new Node(data);
        if(head==null){
            head=temp;
        }
        else {
            Node last = head;
            while(last.next!=null){
                last=last.next;
            }
            last.next=temp;
        }
    }

    public void printList(){
        Node printer = head;
        while(printer!=null){
            System.out.print(printer.data+" ");
            printer=printer.next;
        }
        System.out.println();
    }

    public void printParticularList(Node head){
        Node printer = head;
        while(printer!=null){
            System.out.print(printer.data+" ");
            printer=printer.next;
        }
        System.out.println();
    }

    public void insertAtNthPositionFromStart(int n,int data){
        if(n<1){
            return;
        }
        Node temp = new Node(data);
        LinkedList list = new LinkedList();
        if(n>list.getLengthOfList(head)){
            System.out.println("List is shorter");
            return;
        }
        if(head==null){
            if(n==1){
                head=temp;
                return;
            }
        }
        if(n==1){
            temp.next=head;
            head=temp;
            return;
        }
        Node track = head;
        for (int i=0; i<n-2;i++){
            track=track.next;
        }
        temp.next=track.next;
        track.next=temp;
    }

    public void insertAtNthFromEnd(int n, int data){
        Node temp = new Node(data);
        LinkedList list = new LinkedList();
        System.out.println("To Test : "+list.getLengthOfList(head));
        int length = list.getLengthOfList(head);
        if(n==length){
            temp.next=head;
            head=temp;
            return;
        }
        if(n>length){
            return;
        }
        Node track=head;
        for(int i=0;i<length-n;i++){
            track=track.next;
        }
        temp.next=track.next;
        track.next=temp;
    }

    public int getLengthOfList(Node head){
        int length=0;
        Node temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length;
    }

    public void deleteAtNthPositionFromStart(int n){
        if(n<1){
            return;
        }
        if(head!=null){
            if(n==1){
                head=head.next;
            }
            else{
                Node track = head;
                for(int i=0;i<n-2;i++){
                    track=track.next;
                }
                track.next=track.next.next;
            }
        }
    }

    public void deleteAtNthFromEnd(int n){
        LinkedList list = new LinkedList();
        System.out.println("To Test : "+list.getLengthOfList(head));
        int length = list.getLengthOfList(head);
        if(n==length){
            head=head.next;
        }
        if(n>length){
            return;
        }
        Node track=head;
        for(int i=0;i<length-n-1;i++){
            track=track.next;
        }
        track.next=track.next.next;
    }



    public void reverseLinkedList(){
         Node temp =head;

         Node prev = null;
         Node curr = head;
         Node next = null;
         while(curr!=null){
             next= curr.next;
             curr.next=prev;
             prev=curr;
             curr=next;
         }
         head=prev;
    }

    public Node sortedMerge(Node a,Node b){
        Node result = null;
        if(a==null){
            return b;
        }
        if(b==null){
            return a;
        }

        if(a.data<=b.data){
            result = a;
            result.next = sortedMerge(a.next,b);
        }
        else{
            result = b;
            result.next = sortedMerge(a,b.next);
        }
        return result;
    }


    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node middle = midOfList(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        Node sortedLinkedList = sortedMerge(left,right);
        return sortedLinkedList;

    }

    public Node midOfList(Node head){
        if(head==null){
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        while(fast!=null){
            fast=fast.next;
            if(fast!= null){
                slow=slow.next;
                fast=fast.next;
            }
        }
        //System.out.println("Mid of a LinkedList : "+slow.data);
        return slow;
    }

    public void swap2NodesByPositon(int n1,int n2){
        Node prev1 = null;
        Node curr1 = null;
        Node next1 = null;
        Node prev2 = null;
        Node curr2 = null;
        Node next2 = null;
        Node temp = head;
        if(n1==1){
            curr1 = temp;
            next1 = temp.next;
        }
        if(n1>1){
             prev1 = head;
            for (int i=0;i<n1-2;i++){
                prev1=prev1.next;
            }
             curr1 = prev1.next;
             next1 = prev1.next.next;
        }
        if(n2==1){
            curr2 = temp;
            next2 = temp.next;
        }
        if(n2 > getLengthOfList(head)){
            return;
        }
        if(n2>1){
             prev2 = head;
            for (int i=0;i<n2-2;i++){
                prev2=prev2.next;
            }
             curr2 = prev2.next;
             next2 = prev2.next.next;
        }
        curr1.next=next2;
        prev2.next=curr1;

        curr2.next=next1;
        if(prev1!=null){
            prev1.next=curr2;
        }
        else {
            head = curr2;
        }

    }

    public void swapNodesByLink(Node a, Node b){
        if (a == b) return;

        Node prev1 = null;
        Node curr1 = head;
        Node prev2 = null;
        Node curr2 = head;
        while (curr1 != null && curr1.data!=a.data) {
            prev1=curr1;
            curr1=curr1.next;
        }
        while (curr2 != null && curr2.data!=b.data){
            prev2=curr2;
            curr2=curr2.next;

        }

        if (curr1 == null || curr2 == null)
            return;

        if(prev2==curr1){
            curr1.next=curr2.next;
            curr2.next=curr1;
            if(prev1!=null){
                prev1.next=curr2;
            }
            else
            head = curr2;
            return;
        }

        if(prev1!=null)
            prev1.next=curr2;
        else
            head = curr2;

        if(prev2!=null)
            prev2.next=curr1;
        else
            head = curr1;

        Node tempNode = curr1.next;
        curr1.next = curr2.next;
        curr2.next=tempNode;

    }

    public void swap(Node a){
        int temp = a.data;
        a.data=a.next.data;
        a.next.data=temp;
    }


    public void zigZagList(){
        boolean flag = true;
        Node current = head;
        while(current.next!=null){
            if(flag){
                if(current.data>current.next.data){
                    //swapNodesByLink(current,current.next);//we can swap dat only of node without changing the link
                    swap(current);
                // swap(current.data,current.next.data);
                    }
            }
            else{
                if(current.data<current.next.data) {
                    //swapNodesByLink(current,current.next);
                    swap(current);
                    //swap(current.data,current.next.data);
                }
            }
            current=current.next;
            flag=!flag;
        }
    }


    public static void main(String[] args){
        /*LinkedList linkedList = new LinkedList();
        linkedList.append(12);
        linkedList.append(13);
        linkedList.append(14);
        linkedList.append(15);
        linkedList.printList();
        linkedList.insertAtStart(10);
        linkedList.append(16);
        linkedList.printList();
        System.out.println("Size = "+linkedList.getLengthOfList(linkedList.head));
        linkedList.insertAtStart(9);
        linkedList.insertAtStart(8);
        linkedList.insertAtStart(7);
        linkedList.insertAtStart(6);
        linkedList.insertAtStart(5);
        linkedList.printList();
        linkedList.insertAtNthPositionFromStart(7,11);
        linkedList.printList();
        linkedList.insertAtNthPositionFromStart(7,21);
        linkedList.printList();
        linkedList.deleteAtNthPositionFromStart(7);
        linkedList.printList();
        linkedList.insertAtStart(4);
        linkedList.printList();
        linkedList.insertAtNthFromEnd(1,32);
        linkedList.printList();
        linkedList.insertAtNthFromEnd(2,980);
        linkedList.printList();
        linkedList.insertAtNthFromEnd(15,3);
        linkedList.printList();
        linkedList.deleteAtNthPositionFromStart(1);
        linkedList.printList();
        linkedList.deleteAtNthPositionFromStart(2);
        linkedList.printList();
        linkedList.deleteAtNthFromEnd(2);
        linkedList.printList();
        linkedList.deleteAtNthFromEnd(1);
        linkedList.printList();
        linkedList.reverseLinkedList();
        System.out.println("Reversed Linked List : ");
        linkedList.printList();
        Node mid = linkedList.midOfList(linkedList.head);
        System.out.println("Mid  : "+ mid.data);
        linkedList.swap2NodesByPositon(3,7);
        linkedList.printList();
        System.out.println(linkedList.midOfList(linkedList.head).data);
        Node mergeSortedList = linkedList.mergeSort(linkedList.head);
        linkedList.head = mergeSortedList;
        System.out.println("After Merge Sort : ");
        linkedList.printParticularList(mergeSortedList);
        linkedList.printList();
        System.out.println("Linked After Swapping");
        linkedList.swap2NodesByPositon(1,12);
        linkedList.printList();
        System.out.println("Length : "+linkedList.getLengthOfList(linkedList.head));*/

        LinkedList list=new LinkedList();
        // create a list 4 -> 3 -> 7 -> 8 -> 6 -> 2 -> 1
        // answer should be -> 3  7  4  8  2  6  1
        list.append(4);
        list.append(3);
        list.append(7);
        list.append(8);
        list.append(6);
        list.append(2);
        list.append(1);
        list.printList();
        list.zigZagList();
        System.out.println("zigZag : ");
        list.printList();

    }

}