/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source;

class Node {

    int data;
    Node next;

    Node() {
    }

    Node(int theData) {
        data = theData;
    }
}

class Stackk {

    Node top;
    int size = 0;

    boolean isEmpty() {
        return (size == 0);
    }

    void push(Node input) {
        if (isEmpty()) {
            top = input;
        } else {
            input.next = top;
            top = input;
        }
        size++;
    }

    void pop() {
        if (isEmpty()) {
            return;
        }
        if (size == 1) {
            top = null;
        } else {
            Node temp = top;
            top = temp.next;
            temp.next = null;
        }
        size--;
    }

    void peek() {
        System.out.println(top.data);
    }

    boolean find(int input) {
        Node temp = top;
        while (temp != null) {
            if (temp.data == input) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    void check(int input) {
        Node temp = top;
        for (int i = size; i >= 0; i++) {
            if (temp.data == input) {
                System.out.println(i);
            }
            temp = temp.next;
        }
    }

}

public class Stack {

}
