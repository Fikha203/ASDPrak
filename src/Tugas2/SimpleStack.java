package Tugas2;

import java.util.Scanner;
import java.util.Arrays;

class Node {

    int data;
    Node next;

    Node() {
    }

    Node(int theData) {
        data = theData;
    }
}

class Stack {

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

    void print() {
        Node temp = top;
        int[] arr = new int[size];
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = temp.data;
            temp = temp.next;
        }

        System.out.println(Arrays.toString(arr));
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

public class SimpleStack {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack list = new Stack();
        int m = in.nextInt();
        in.nextLine();
        String arr[] = new String[2];
        for (int i = 0; i < m; i++) {
            arr = in.nextLine().split(" ");
            switch (arr[0]) {
                case "push": {
                    list.push(new Node(Integer.parseInt(arr[1])));
                }
                break;
                case "pop": {
                    list.pop();
                }
                break;
                case "peek": {
                    list.peek();
                }
                break;
                case "isEmpty": {
                    if (list.isEmpty()) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                }
                break;
                case "find": {
                    if (list.find(Integer.parseInt(arr[1]))) {
                        System.out.println("true");
                    } else {
                        System.out.println("false");
                    }
                }
                break;
                case "check": {
                    list.check(Integer.parseInt(arr[1]));
                }
                break;
                case "print": {
                    list.print();
                }
                break;
            }
        }
    }
}
