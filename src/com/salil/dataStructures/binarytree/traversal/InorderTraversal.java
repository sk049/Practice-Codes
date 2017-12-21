package com.salil.dataStructures.binarytree.traversal;

import java.util.Stack;

/**
 * Created by Salil on 01/11/17.
 */
public class InorderTraversal {

    Node root;

    static class Node{
        int key;
        Node left,right;

        Node(int key){
            this.key=key;
            this.left=null;
            this.right=null;
        }
    }

    public void inOrderWithOutRecurssion(){
        if(root==null)
            return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while (node!=null){
            stack.push(node);
            node = node.left;
        }
        while(stack.size()>0){
            Node temp = stack.pop();
            System.out.print(temp.key+"\t");
            if(temp.right!=null){
                temp= temp.right;
                while(temp!=null){
                    stack.push(temp);
                    temp=temp.left;
                }
            }
        }
    }

    public static void main(String args[])
    {
        InorderTraversal tree = new InorderTraversal();
        tree.root= new InorderTraversal.Node(1);
        tree.root.left= new InorderTraversal.Node(2);
        tree.root.right= new InorderTraversal.Node(3);
        tree.root.left.left= new InorderTraversal.Node(4);
        tree.root.left.right= new InorderTraversal.Node(5);
        tree.root.left.right.right= new InorderTraversal.Node(7);
        tree.root.left.right.right.left= new InorderTraversal.Node(8);

        System.out.println("Inordrer Traversal w/o recurssion is : ");
        tree.inOrderWithOutRecurssion();

    }


}
