package Source;

class Node {

    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        right = null;
        left = null;
    }
}

class Tree {

    Node root;
    int size = 0;

    void add(int data) {
        root = addRecursive(data, root);
    }


    Node addRecursive(int data, Node current) {
        if (current == null) {
            Node temp = new Node(data);
            return temp;
//            return new Node(data);
        } else {
            if (data > current.data) {
                current.right = addRecursive(data, current.right);
            } else if (data < current.data) {
                current.left = addRecursive(data, current.left);
            }
        }
        return current;
    }

    void preorderTraversal() {
        preorder(root);
    }

    void preorder(Node current) {
        if (current != null) {
            System.out.printf(current.data + " ");
            preorder(current.left);
            preorder(current.right);
        }
    }

    void inorder(Node current) {
        if (current != null) {
            inorder(current.left);
            System.out.printf(current.data + " ");
            inorder(current.right);
        }
    }

    void postorder(Node current) {
        if (current != null) {
            postorder(current.left);
            postorder(current.right);
            System.out.printf(current.data + " ");
        }
    }
    
    boolean contains(int data){
        return containsRecursive(data, root);
    }
    
    private boolean containsRecursive(int data, Node current){
        if(current == null){
            return false;
        }
        if(data == current.data){
            return true;
        }
        if(data < current.data){
            return containsRecursive(data, current.left);
        } else if (data > current.data){
            return containsRecursive(data,current.right);
        }
        return false;
    }
    
    private Node deleteNode(int data, Node current){
        if(current == null){
            return root;
        }
        if(current.data > data){
            current.left = deleteNode(data, current.left);
            return current;
        } else if (current.data < data){
            current.left = deleteNode(data, current.right);
            return current;
        }
        
        //sama
        if(current.left == null){
            // node Temp = current.right
            return current.right;
        } else if(root.right == null){
            return current.left;
        } else {
            Node parent = current;
            Node succesor = current.right;
            
            while(succesor.left != null){
                parent = succesor;
                succesor = succesor.left;
            }
            if(parent != root){
                parent.left = succesor.right;
            } else {
                parent.right = succesor.right;
            }
            current.data = succesor.data;
            return current;
        }
    }
    void delete(int data){
        root = deleteNode(data,root);
    }

//    int getValue(Node current) {
//        if(current == null){
//            return +0;
//        }
//    }
}

public class BinTree {

    public static void main(String[] args) {
        Tree hakim = new Tree();
        hakim.add(44);
        hakim.add(25);
        hakim.add(69);
        hakim.add(89);
        hakim.add(50);
        hakim.add(65);
        hakim.add(56);
        hakim.add(85);
        hakim.add(88);
        hakim.add(25);
        hakim.add(37);
        hakim.add(10);
        hakim.add(13);
        hakim.add(8);
        hakim.preorderTraversal();
        System.out.println("");
        hakim.inorder(hakim.root);
        System.out.println("");
        hakim.postorder(hakim.root);
        System.out.println("");
        if(hakim.contains(9)){
            System.out.println("ada");
        } else {
            System.out.println("tdk ada");
        }
        hakim.delete(37);
        hakim.inorder(hakim.root);
    }
}
