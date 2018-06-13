package com.salil.dataStructures.binarytree.traversal;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Created by SALIL on 08/11/17.
 */
public class VerticalTraversal {

    Node root;

    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    public void verticalOrderUtil(Node root , int d , Map<Integer,Vector<Integer>>verticalOrderMap){
        if (root== null)
            return;

        Vector<Integer> k = verticalOrderMap.get(d);
        if (k==null){
            k = new Vector<>();
            k.add(root.data);
        }
        else {
            k.add(root.data);
        }
        verticalOrderMap.put(d,k);
        verticalOrderUtil(root.left,d-1,verticalOrderMap);
        verticalOrderUtil(root.right,d+1,verticalOrderMap);

    }

    public void verticalOrder(Node root){
        TreeMap<Integer,Vector<Integer>> verticalOrderMap = new TreeMap<>();
        verticalOrderUtil(root,0,verticalOrderMap);
        System.out.println("Vertical Traversal of tree : ");
        System.out.println(verticalOrderMap.entrySet());
        //verticalOrderMap = new TreeMap<Integer,Vector<Integer>>(verticalOrderMap);
        for(Map.Entry<Integer,Vector<Integer>> entry : verticalOrderMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void main(String args[])
    {
        VerticalTraversal tree = new VerticalTraversal();
        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);

        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }

}
