/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LCBinaryTree;

import java.util.Scanner;

/**
 *
 * @author HHR
 */
class Node {

    char data;
    Node left;
    Node right;

    Node(char data) {
        this.data = data;
        right = null;
        left = null;
    }
}

class Tree {

    Node root;

    void add(char data) {
        root = addRecursive(data, root);
    }

    private Node addRecursive(char data, Node current) {
        if (current == null) {
            return new Node(data);
        } else {
            if (data > current.data) {
                current.right = addRecursive(data, current.right);
            } else if (data < current.data) {
                current.left = addRecursive(data, current.left);
            } else {
                return current;
            }
        }
        return current;
    }

    void preorder() {
        preorderRecursive(root);
        System.out.println("");
    }

    private void preorderRecursive(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            preorderRecursive(current.left);
            preorderRecursive(current.right);
        }
    }
    void inorder() {
        inorderRecursive(root);
        System.out.println("");
    }

    private void inorderRecursive(Node current) {
        if (current != null) {
            inorderRecursive(current.left);
            System.out.print(current.data + " ");
            inorderRecursive(current.right);
        }
    }

    void postorder() {
        postorderRecursive(root);
        System.out.println("");
    }
    private void postorderRecursive(Node current) {
        if (current != null) {
            postorderRecursive(current.left);
            postorderRecursive(current.right);
            System.out.print(current.data + " ");
        }
    }
}

public class pohonKerinduan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tree pohon = new Tree();
        String str = input.nextLine();
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            pohon.add(arr[i]);       
        }
        
        System.out.println("Preorder traversal");
        pohon.preorder();
        System.out.println("Inorder traversal");
        pohon.inorder();
        System.out.println("Postorder traversal");
        pohon.postorder();
    }
}
