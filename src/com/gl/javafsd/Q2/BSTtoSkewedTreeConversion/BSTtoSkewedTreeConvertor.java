package com.gl.javafsd.Q2.BSTtoSkewedTreeConversion;

// class to convert BST into right skewed tree
public class BSTtoSkewedTreeConvertor {

    // root nodes for BST and Skewed trees (ST) respectively
    static Node rootOfBST;
    static Node rootOfST;

    // constructor to store root node of BST tree as input during Object creation
    public BSTtoSkewedTreeConvertor (Node root){
        this.rootOfBST = root;
    }

    // method that employs recursive calling to find ascending order of nodes (similar to inorder traversal)
    // and then stores it as skewed tree
    public static void convert (Node BST_root){
        if (BST_root == null)
            return;
        else
        {
            // recursive call for left nodes
            convert(BST_root.left);
            // creates new node with value of nodes of BST
                Node newNode = getNewNode(BST_root.data);
                Node x= rootOfST;
                Node current_parent = null;

                // finds the empty right node of skewed tree
                while (x!=null){
                    current_parent = x;
                    x= x.right;
                }

                // if root node of skewed tree is empty, BST node is stored in it
                if (current_parent== null){
                    //current_parent= newNode;
                    rootOfST = newNode;
                } // right node of skewed tree stores the next BST node
                else{
                    current_parent.right= newNode;
                }
            // recursive call for right nodes of BST
            convert(BST_root.right);
        }
    }

    // pre-order traversal code for any tree with its root as input
    public static void preOrder( Node root){
        if (root==null)
            return;
        else
        {
            System.out.print(root.data+"  ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // method to get a new node storing the given value
    public static Node getNewNode(int value){
        Node newNode = new Node (value);
        return newNode;
    }

    // method that calls convert function and prints inorder traversal of right skewed root
    public void conversion (){
        convert(rootOfBST);
        System.out.println("\n \nPrinting the pre-order traversal of Skewed tree-->");
        preOrder(rootOfST);
    }
}
