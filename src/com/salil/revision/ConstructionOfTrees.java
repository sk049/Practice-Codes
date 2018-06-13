package com.salil.revision;

import java.util.Stack;

public class ConstructionOfTrees {

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

    public int searchInInOrder(int in[],int start,int end,int value){
        int i;
        for( i = start;i<=end;i++){
            if(in[i]==value)
                return i;
        }
        return i;
    }
    static int preIndex = 0;
    public Node buildTreeFromPreAndInOrder(int in[],int pre[],int inStart,int inEnd){
        if(inStart>inEnd)
            return null;
        Node tempNode = new Node(pre[preIndex++]);
        if(inStart==inEnd)
            return tempNode;
        int inOrderIndex = searchInInOrder(in,inStart,inEnd,tempNode.key);
        tempNode.left= buildTreeFromPreAndInOrder(in,pre,inStart,inOrderIndex-1);
        tempNode.right=buildTreeFromPreAndInOrder(in,pre,inOrderIndex+1,inEnd);
        return tempNode;
    }

    public void printPostOrder(Node node){
        if (node == null)
            return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.print(node.key +"\t");
        }

    public static void main(String args[])
    {
        ConstructionOfTrees tree = new ConstructionOfTrees();
        int in[] = {4, 2, 5, 1, 3, 6};
        int pre[] = {1, 2, 4, 5, 3, 6};
        int len = in.length;
        Node root = tree.buildTreeFromPreAndInOrder(in, pre, 0, len - 1);
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printPostOrder(root);
    }

}
