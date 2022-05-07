package com.gl.javafsd.Q2.BSTtoSkewedTreeConversion;

public class Main {

    public static void main(String[] args) {

        // hardcode for the BST tree as given in the question
        Node BSTRoot = new Node (50);
        BSTRoot.left= new Node(30);
        BSTRoot.right = new Node(60);
        BSTRoot.left.left= new Node (10);
        BSTRoot.right.left= new Node(55);

        // creating an object for BSTtoSkewedTreeConvertor
        BSTtoSkewedTreeConvertor convertor= new BSTtoSkewedTreeConvertor(BSTRoot);

        // printing the pre-order traversal for BST
        System.out.println("Printing the pre-order traversal of BST-->");
        convertor.preOrder(BSTRoot);

        // calling the function to convert BST into Right Skewed tree
        // and print its pre-order traversal
        convertor.conversion();
    }

}
