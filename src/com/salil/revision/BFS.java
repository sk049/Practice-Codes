package com.salil.revision;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;
import javafx.beans.property.ReadOnlyObjectProperty;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

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
        int h = treeHeight(root);
        for(int i=1;i<=h;i++){
            printGivenLevel(root,i);
        }

    }

    public void printGivenLevel(Node root,int height){
        if(root == null)
            return;
        if(height==1)
            System.out.println(root.key);
        printGivenLevel(root.left,height-1);
        printGivenLevel(root.right,height-1);

    }

    public int treeHeight(Node root){
        if(root == null)
            return 0;

        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);

        if(leftHeight>rightHeight)
            return leftHeight+1;
        else
            return rightHeight+1;

    }

    public void printLevelOrderByQueue(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.key);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
    }

    public void bfsByLevelByQueue(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (true){
            int nodeCount = queue.size();
            if (nodeCount == 0)
                break;

            while (nodeCount>0){
                Node tempNode = queue.poll();
                System.out.print(tempNode.key + "\t");
                if(tempNode.left!=null)
                    queue.add(tempNode.left);
                if(tempNode.right!=null)
                    queue.add(tempNode.right);
                nodeCount--;
            }
            System.out.println();
        }

    }

    public static void main(String args[]){
        BFS tree = new BFS();
        tree.root= new Node(1);
        tree.root.left= new Node(2);
        tree.root.right= new Node(3);
        tree.root.left.left= new Node(4);
        tree.root.left.right= new Node(5);
        tree.root.left.right.right= new Node(7);
        tree.root.left.right.right.left= new Node(8);
        tree.printLevelOrder();
        System.out.println("BFS by queue");
        tree.printLevelOrderByQueue();
        System.out.println("BFS By Level By Queue");
        tree.bfsByLevelByQueue();

    }


}
