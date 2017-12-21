package com.salil.dataStructures.binarytree.traversal;

import java.util.*;

/**
 * Created by SALIL on 09/11/17.
 */
public class SpecificLevelOrder {

    Node root;

    static class Node
    {
        int data;
        Node left, right;

        public Node(int item)
        {
            data = item;
            left = right = null;
        }
    }


    public void printSpecificLevelOrder(Node root) {
        TreeMap<Integer, Vector<Integer>> specificMap = new TreeMap<>();
        specificLevelOrder(root, specificMap, 0);
        System.out.println(specificMap.entrySet());
        for (Map.Entry<Integer, Vector<Integer>> entry : specificMap.entrySet()) {

            Vector<Integer> tempVector = specificMap.get(entry.getKey());

            if(tempVector.size()==1){
                System.out.print("Root: "+ tempVector.get(0));
            }
            if(tempVector.size()==2){
                System.out.print(tempVector.get(0)+"\t");
                System.out.print(tempVector.get(1)+"\t");

            }
            else{
                int i=0;
                int j=tempVector.size()-1;
                int mid1 = tempVector.size()/2;
                while(i<mid1-1){
                    System.out.print(tempVector.get(i)+"\t");
                    System.out.print(tempVector.get(j)+"\t");
                    i++;
                    j--;
                }
            }

            System.out.println();

            //System.out.println(mid);

        }
    }

    public void specificLevelOrder(Node root, TreeMap<Integer,Vector<Integer>> specificMap,int key){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            int nodeCount = queue.size();
            if(nodeCount==0 )
                break;
            Vector<Integer> k = new Vector<>();
            while(nodeCount>0){
                Node node = queue.peek();
                k.add(node.data);
                queue.remove();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                nodeCount--;
            }
            specificMap.put(key,k);
            key++;
        }

    }


    public void specificLevelOrderTraversalBy2Nodes(Node root){
        if(root==null)
            return;
        System.out.print(root.data+"\t");
        if(root.left!=null){
            System.out.print(root.left.data+"\t"+root.right.data+"\t");
        }
        if(root.left.left==null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root.left);
        q.add(root.right);
        Node first = null , second=null;
        while (!q.isEmpty()){
            first = q.peek();
            q.remove();
            second = q.peek();
            q.remove();
            System.out.print(first.left.data+"\t"+second.right.data+"\t");
            System.out.print(first.right.data+"\t"+second.left.data+"\t");
            if(first.left.left!=null){
                q.add(first.left);
                q.add(second.right);
                q.add(first.right);
                q.add(second.left);
            }
         }
    }

    public void specificLevelOrderBottomUp(Node root){
        if(root==null)
            return;
        Stack<Node> s = new Stack<>();
        Queue<Node> q = new LinkedList<>();
        s.add(root);
        if(root.left!=null){
            s.add(root.left);
            s.add(root.right);
        }
        if(root.left.left==null)
            return;
        q.add(root.left);
        q.add(root.right);
        Node first = null, second=null;
        while(!q.isEmpty()){
            first=q.peek();
            q.remove();
            second=q.peek();
            q.remove();
            s.add(first.left);
            s.add(second.right);
            s.add(first.right);
            s.add(second.left);
            if(first.left.left!=null){
                q.add(first.left);
                q.add(second.right);
                q.add(first.right);
                q.add(second.left);
            }
        }
        while (!s.isEmpty()){
            System.out.print(s.pop().data+"\t");
        }

    }


    public static void main(String args[])
    {
        SpecificLevelOrder tree = new SpecificLevelOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);

        tree.root.left.left.left.left = new Node(16);
        tree.root.left.left.left.right = new Node(17);
        tree.root.left.left.right.left = new Node(18);
        tree.root.left.left.right.right = new Node(19);
        tree.root.left.right.left.left = new Node(20);
        tree.root.left.right.left.right = new Node(21);
        tree.root.left.right.right.left = new Node(22);
        tree.root.left.right.right.right = new Node(23);
        tree.root.right.left.left.left = new Node(24);
        tree.root.right.left.left.right = new Node(25);
        tree.root.right.left.right.left = new Node(26);
        tree.root.right.left.right.right = new Node(27);
        tree.root.right.right.left.left = new Node(28);
        tree.root.right.right.left.right = new Node(29);
        tree.root.right.right.right.left = new Node(30);
        tree.root.right.right.right.right = new Node(31);

        System.out.println("Specific Level Order traversal of binary"
                +"tree is ");
        tree.printSpecificLevelOrder(tree.root);
        System.out.println("Specific Level Order Traversal By 2 nodes : ");
        tree.specificLevelOrderTraversalBy2Nodes(tree.root);
        System.out.println();
        System.out.println("Specific Level Order Traversal Bottom-Up : ");
        tree.specificLevelOrderBottomUp(tree.root);
    }

}
