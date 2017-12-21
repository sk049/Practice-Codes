package com.salil.dataStructures.binarytree.traversal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

/**
 * Created by Salil on 07/11/17.
 */


// Java program for diagonal traversal of Binary Tree


public class DiagonalTraversalBTree
{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data=data;
            left = null;
            right =null;
        }
    }

    public void diagonalPrint(Node root)
    {

        HashMap<Integer,Vector<Integer>> diagonalPrint = new HashMap<>();
        diagnolPrintUtil(root, 0, diagonalPrint);

        System.out.println("Diagonal Traversal of Binnary Tree");
        for (Entry<Integer, Vector<Integer>> entry : diagonalPrint.entrySet())
        {
            System.out.println(entry.getValue());
        }
    }


    public void diagnolPrintUtil(Node root, int d, Map<Integer,Vector<Integer>> diagnolMap){
        if(root == null)
        return;

        Vector<Integer> k = diagnolMap.get(d);

        if(k==null){
            k = new Vector<>();
            k.add(root.data);
        }
        else{
            k.add(root.data);
        }

        diagnolMap.put(d,k);

        diagnolPrintUtil(root.left,d+1,diagnolMap);
        diagnolPrintUtil(root.right,d,diagnolMap);

    }

    // Driver program
    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        DiagonalTraversalBTree object = new DiagonalTraversalBTree();
        object.diagonalPrint(root);
    }
}