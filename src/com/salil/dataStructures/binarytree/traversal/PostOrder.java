package com.salil.dataStructures.binarytree.traversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Salil on 01/11/17.
 */
public class PostOrder {
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

    public void postOrderByIteration(Node root){

        // Create two stacks
       Stack<Node> s1 = new Stack<>();
       Stack<Node> s2 = new Stack<>();
        if (root == null)
            return;
        // push root to first stack
        s1.push(root);
        // Run while first stack is not empty
        while (!s1.isEmpty())
        {
            // Pop an item from s1 and push it to s2
            Node temp = s1.pop();
            s2.push(temp);

            // Push left and right children of
            // removed item to s1
            if (temp.left != null)
                s1.push(temp.left);
            if (temp.right != null)
                s1.push(temp.right);
        }

        // Print all elements of second stack
        while (!s2.isEmpty())
        {
            Node temp = s2.pop();
            System.out.print(temp.key + " ");
        }

    }


    ArrayList<Integer> list = new ArrayList<Integer>();

    // An iterative function to do postorder traversal
    // of a given binary tree
    ArrayList<Integer> postOrderIterative(Node node)
    {
        Stack<Node> S = new Stack<Node>();

        // Check for empty tree
        if (node == null)
            return list;
        S.push(node);
        Node prev = null;
        while (!S.isEmpty())
        {
            Node current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current || prev.right == current)      // Its to check prev is root`
            {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.key);
                }

                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
            }
            else if (current.left == prev)
            {
                if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.key);
                }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            }
            else if (current.right == prev)
            {
                S.pop();
                list.add(current.key);
            }

            prev = current;
        }

        return list;
    }




    public void postOrderByRecurssion(Node root){
        if(root==null)
            return;
        postOrderByRecurssion(root.left);
        postOrderByRecurssion(root.right);
        System.out.print(root.key+"\t");
    }

    public static void main(String[] args){

        PostOrder tree = new PostOrder();
        /*tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);*/

        /*tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.left.right.right= new Node(7);
        tree.root.left.right.right.left= new Node(8);*/

        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.left.right.right= new Node(7);
        tree.root.left.right.right.left= new Node(8);

        System.out.println("Post Order : ");
        tree.postOrderByRecurssion(tree.root);
        System.out.println();
        System.out.println("Post Order By Iteration is : ");
        tree.postOrderByIteration(tree.root);
    }

}
