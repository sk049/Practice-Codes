package com.salil.dataStructures.binarytree.traversal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Salil on 31/10/17.
 */
public class LevelOrderTraversal {

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

    public void printLevelOrder(){
        int h=height(root);
        for(int i=1;i<=h;i++){
            System.out.println("Level : "+i);
            printGivenLevel(root,i);
        }

    }

    public void printGivenLevel(Node root,int level){
        if(root==null)
            return;
        if(level==1)
            System.out.println(root.key+"  ");
        else if(level>1)
            printGivenLevel(root.left,level-1);
            printGivenLevel(root.right,level-1);
    }

    public int height(Node root){
        if(root == null)
            return 0;

        int lHeight = height(root.left);
        int rHeight = height(root.right);

        if(lHeight>rHeight)
            return lHeight+1;
        else
            return rHeight+1;

    }

    public void levelOrderByQueue(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
           Node temp = queue.poll();
            System.out.println(temp.key);
           if(temp.left!=null)
               queue.add(temp.left);
           if(temp.right!=null)
               queue.add(temp.right);
        }
    }


    public void levelOrderByLevel(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(true){
            int nodeCount = queue.size();
            if(nodeCount==0 )
                break;

            while(nodeCount>0){
                Node node = queue.peek();
                System.out.print(node.key+ "  ");
                queue.remove();
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
                nodeCount--;
            }
            System.out.println();
        }
    }

    public void levelOrder(Node root)
    {
        Queue<Node> q1 = new LinkedList<Node>();
        Queue<Node> q2 = new LinkedList<Node>();

        if (root == null)
            return;

        // Pushing first level node into first queue
        q1.add(root);

        // Executing loop till both the queues
        // become empty
        while (!q1.isEmpty() || !q2.isEmpty())
        {

            while (!q1.isEmpty())
            {

                // Pushing left child of current node in
                // first queue into second queue
                if (q1.peek().left != null)
                    q2.add(q1.peek().left);

                // pushing right child of current node
                // in first queue into second queue
                if (q1.peek().right != null)
                    q2.add(q1.peek().right);

                System.out.print(q1.peek().key + " ");
                q1.remove();
            }
            System.out.println();

            while (!q2.isEmpty())
            {

                // pushing left child of current node
                // in second queue into first queue
                if (q2.peek().left != null)
                    q1.add(q2.peek().left);

                // pushing right child of current
                // node in second queue into first queue
                if (q2.peek().right != null)
                    q1.add(q2.peek().right);

                System.out.print(q2.peek().key + " ");
                q2.remove();
            }
            System.out.println();
        }
    }

    public static void main(String args[])
    {
        LevelOrderTraversal tree = new LevelOrderTraversal();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.left.right.right= new Node(7);
        tree.root.left.right.right.left= new Node(8);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();

        System.out.println("Level Order By Queue is : ");
        tree.levelOrderByQueue();

        System.out.println("Level Order by level : ");
        tree.levelOrderByLevel();
    }

}
