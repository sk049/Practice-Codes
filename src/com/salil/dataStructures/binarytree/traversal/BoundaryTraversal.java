package com.salil.dataStructures.binarytree.traversal;

/**
 * Created by SALIL on 08/11/17.
 */
public class BoundaryTraversal {


    static Node root;

    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    public void printLeaves(Node node){
        if(node!=null){
            printLeaves(node.left);
            if(node.left==null && node.right ==null)
                System.out.print(node.data+"\t");
            printLeaves(node.right);
        }
    }


    public void printBoundaryLeft(Node node){
        if(node!=null){
            if (node.left!=null){
                System.out.print(node.data+"\t");
                printBoundaryLeft(node.left);
            }
            else if(node.right!=null){
                System.out.print(node.data+"\t");
                printBoundaryLeft(node.left);
            }
        }
    }

    public void printBoundaryRight(Node node){
        if(node!=null){
            if(node.right!=null){
                printBoundaryRight(node.right);
                System.out.print(node.data+"\t");
            }
            else if(node.left!=null){
                printBoundaryRight(node.right);
                System.out.print(node.data+"\t");
            }
        }
    }

    public void printBoundary(Node node){
        if(node!=null){
            System.out.print(node.data+"\t");

            printBoundaryLeft(node.left);
            printLeaves(node.left);
            printLeaves(node.right);
            printBoundaryRight(node.right);

        }
    }

    public static void main(String args[])
    {
        BoundaryTraversal tree = new BoundaryTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(4);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.left.left = new Node(8);
        tree.root.left.left.left.left.left = new Node(12);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(9);
        tree.root.left.right.right.right = new Node(10);
        tree.root.left.right.right.right.left = new Node(11);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(6);
        tree.printBoundary(tree.root);

    }

}
