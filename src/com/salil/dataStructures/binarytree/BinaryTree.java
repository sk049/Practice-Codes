package com.salil.dataStructures.binarytree;

/**
 * Created by Salil on 31/10/17.
 */
public class BinaryTree {

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

    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root= new Node(5);
    }


}
