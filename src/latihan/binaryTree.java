package latihan;

import java.util.Scanner;

class Node {

    Node left;
    Node right;
    int value;

    Node(int value) {
        this.value = value;
        left = right = null;
    }
}

class Binary_Tree {

    Node root;
    Node temp;

    Binary_Tree() {
        root = null;
    }

    Binary_Tree(Node newNode) {
        if (root == null) {
            root = newNode;
        }
    }

    void insertion(Node newNode) {
    
        
    }

    void preorderTraver() {
        preorder(root);
    }

    void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }
//    int getValue() {
//        //Isi sendiri
//    }
}

public class binaryTree {

    public static void main(String[] args) {
        Binary_Tree binaryTree = new Binary_Tree();
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            binaryTree.insertion(new Node(in.nextInt()));
        }
//        System.out.println(binaryTree.getValue());
        binaryTree.preorderTraver();
    }
}
