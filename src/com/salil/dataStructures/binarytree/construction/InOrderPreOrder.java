package com.salil.dataStructures.binarytree.construction;

/**
 * Created by SALIL on 10/11/17.
 */
public class InOrderPreOrder {

    Node root;
    static int preIndex = 0;

    static class Node
    {
        char data;
        Node left, right;

        public Node(char item)
        {
            data = item;
            left = right = null;
        }
    }

    public int searchInInOrder(char in[],int start,int end,char value){
        int i;
        for( i = start;i<=end;i++){
            if(in[i]==value)
                return i;
        }
        return i;
    }

    public Node buildTree(char in[],char pre[],int inStart,int inEnd){
        if(inStart>inEnd)
            return null;
        Node tempNode = new Node(pre[preIndex++]);
        if(inStart==inEnd)
            return tempNode;

        int inOrderIndex = searchInInOrder(in,inStart,inEnd,tempNode.data);

        tempNode.left= buildTree(in,pre,inStart,inOrderIndex-1);
        tempNode.right=buildTree(in,pre,inOrderIndex+1,inEnd);

        return tempNode;
    }

    public void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        InOrderPreOrder tree = new InOrderPreOrder();
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        Node root = tree.buildTree(in, pre, 0, len - 1);
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }

}
