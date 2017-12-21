package com.salil.dataStructures.binarytree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Salil on 02/11/17.
 */
public class ReverseLevelOrderTraversal {

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

    public void printReverseLevelOrder(){
        int h = treeHeight(root);
        for(int i=h;i>0;i--){
            System.out.println("height : "+i);
            reverseLevelOrderTraversal(root,i);
        }

    }

    public void reverseLevelOrderTraversal(Node root,int level){
        if(root==null)
            return;
        if(level==1)
            System.out.println(root.key+"\t");
        else if(level>1){
            reverseLevelOrderTraversal(root.left,level-1);
            reverseLevelOrderTraversal(root.right,level-1);
        }


    }

    public int treeHeight(Node node){
        if(node==null)
            return 0;
        int lHeight = treeHeight(node.left);
        int rHeight = treeHeight(node.right);

        if(lHeight>rHeight)
            return lHeight+1;
        else
            return rHeight+1;
    }

    void printReverseLevelOrderByQnS(){
        if(root==null)
            return;
        Stack<Node> stack = new Stack<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            stack.push(temp);
            if(temp.right!=null)
                queue.add(temp.right);
            if(temp.left!=null)
                queue.add(temp.left);
        }


        while (!stack.isEmpty()){
            System.out.print(stack.pop().key+"\t");
        }
    }

    public static void main(String[] args){
        ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.left.right.right= new Node(7);
        tree.root.left.right.right.left= new Node(8);
        tree.printReverseLevelOrder();
        System.out.println("Reverse Level Order By QnS :");
        tree.printReverseLevelOrderByQnS();
    }

}


