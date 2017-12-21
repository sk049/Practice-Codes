package com.salil.dataStructures.binarytree.traversal;

/**
 * Created by Salil on 01/11/17.
 */



/*
*
*       1. Initialize current as root
*       2. While current is not NULL
*   If current does not have left child
*        a) Print current’s key
*        b) Go to the right, i.e., current = current->right
*   Else
*       a) Make current as right child of the rightmost
*          node in current's left subtree
*       b) Go to this left child, i.e., current = current->left
*
*
*
* */


public class MorrisTraversal {

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


    void MorrisTraversal(Node root) {
        Node current, pre;

        if (root == null)
            return;

        current = root;
        while (current != null)
        {
            if (current.left == null)
            {
                System.out.print(current.key + " ");
                current = current.right;
            }
            else
            {
                /* Find the inorder predecessor of current */
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null)
                {
                    pre.right = current;
                    current = current.left;
                }

                 /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecssor*/
                else
                {
                    pre.right = null;
                    System.out.print(current.key + " ");
                    current = current.right;
                }   /* End of if condition pre->right == NULL */

            } /* End of if condition current->left == NULL*/

        } /* End of while */

    }

    public static void main(String args[])
    {
        MorrisTraversal tree = new MorrisTraversal();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.left.right.right= new Node(7);
        tree.root.left.right.right.left= new Node(8);

        System.out.println("Inordrer Traversal w/o recurssion & w/o stack is : ");
        tree.MorrisTraversal(tree.root);

    }


}
