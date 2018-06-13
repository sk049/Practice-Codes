package com.salil.revision;

import java.util.Stack;

public class DFSWithoutRecursion {

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

    public void inorderWithoutRecursion(){
        if(root==null)
            return;
        Stack<Node> stack = new Stack<>();
        Node node = root;
        while(node!=null){
            stack.push(node);
            node=node.left;
        }
        while (!stack.isEmpty()){
            Node tempNode = stack.pop();
            System.out.print(tempNode.key+"\t");
            if(tempNode.right!=null){
                tempNode = tempNode.right;
                while (tempNode!=null){
                    stack.add(tempNode);
                    tempNode=tempNode.left;
                }
            }
        }
    }

    public void preOrderWithoutRecursion(){
        if(root==null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node tempNode = stack.pop();
            System.out.print(tempNode.key+"\t");
            if(tempNode.right!=null)
                stack.push(tempNode.right);
            if(tempNode.left!=null)
                stack.push(tempNode.left);
            }
}

    public void postOrderWithoutRecursion(){
        if(root==null)
            return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            Node tempNode = stack1.pop();
            stack2.push(tempNode);
            if(tempNode.left!=null)
                stack1.push(tempNode.left);
            if(tempNode.right!=null)
                stack1.push(tempNode.right);

        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().key+"\t");
        }
    }

    public static void main(String [] args ){
        DFSWithoutRecursion tree = new DFSWithoutRecursion();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.left.right.right= new Node(7);
        tree.root.left.right.right.left= new Node(8);

        System.out.println("Inordrer Traversal w/o recurssion is : ");
        tree.inorderWithoutRecursion();
        System.out.println();
        System.out.println("Preorder Traversal w/o recursion is : ");
        tree.preOrderWithoutRecursion();
        System.out.println();
        System.out.println("Postorder Traversal w/o recursion is : ");
        tree.postOrderWithoutRecursion();

    }

}
