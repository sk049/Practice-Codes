package com.salil.dataStructures.binarytree.traversal;

import java.util.Stack;

/**
 * Created by Salil
 * on 01/11/17.
 */
public class PreOrderTraversal {
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

    public void iterativePreorder(){
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node node = root;
        stack.push(root);
        while(stack.size()>0){
            Node temp = stack.pop();
            System.out.print(temp.key + "\t");
            if (temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

    public void recurssivePreOrder(Node root){
        if(root==null)
            return;
        System.out.print(root.key+"\t");
        recurssivePreOrder(root.left);
        recurssivePreOrder(root.right);
    }

    public static void main(String[] args){

        PreOrderTraversal tree = new PreOrderTraversal();
        /*tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);*/

        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.left.right.right= new Node(7);
        tree.root.left.right.right.left= new Node(8);

        tree.iterativePreorder();
        System.out.println();
        tree.recurssivePreOrder(tree.root);
    }

}
