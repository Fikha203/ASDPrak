package LC2;

import java.util.Scanner;

class Node {

    char data;
    Node next;

    Node() {
    }

    Node(char data) {
        this.data = data;
    }

    Node(char data, Node next) {
        this.data = data;
        this.next = next;
    }

}

class Stack {

    int size = 0;
    Node top;

    void pushNewNode(Node newNode) {
        if (!isEmpty()) {
            newNode.next = top;
        }
        top = newNode;
        size++;
    }

    void popNode() {
        if (!isEmpty()) {
            if (size == 1) {
                top = null;
            } else {
                Node temp = top;
                top = temp.next;
                temp.next = null;
            }
            size--;
        }
    }

    boolean isEmpty() {
        return size == 0;
    }

    char peek() {
        return top.data;
    }

    int size() {
        return this.size;
    }

}

public class Soal1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        Stack data = new Stack();
        String str = input.next();
        char[] kata = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (kata[i] == '(' || kata[i] == '{' || kata[i] == '[') {
                data.pushNewNode(new Node(kata[i]));
            } else if (kata[i] == ')' && data.peek() == '(') {
                data.popNode();
                count += 1;
            } else if (kata[i] == ']' && data.peek() == '[') {
                data.popNode();
                count += 1;
            } else if (kata[i] == '}' && data.peek() == '{') {
                data.popNode();
                count += 1;
            }
        }

        if (count == kata.length / 2) {
            System.out.println("Seimbang " + count);
        } else {
            System.out.println("Tidak Seimbang");
        }
    }
}
