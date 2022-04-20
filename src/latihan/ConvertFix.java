package latihan;

import java.util.Scanner;

class Node {

    char data;
    Node next;

    Node(char data) {
        this.data = data;
    }
}

class Stack {

    Node top;
    int size = 0;

    void push(char c) {
        Node input = new Node(c);
        if (size == 0) {
            top = input;
        } else {
            input.next = top;
            top = input;
        }
        size++;
    }

    void pop() {
        if (size != 0) {
            if (size == 1) {
                top = null;
            } else {
                Node temp = top;
                top = temp.next;
                temp.next = null;
                temp = null;
            }
            size--;
        }

    }

    void tampil() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
    }

    char peek() {
        return top.data;
    }
}

public class ConvertFix {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        char[] arr = str.toCharArray();
        Stack data = new Stack();
        boolean cek = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/' || arr[i] == '^') {
                if (cek) {
                    if (data.size != 0) {
                        System.out.print(data.peek());
                        data.pop();
                    }
                }
                data.push(arr[i]);
                cek = true;
            } else if (arr[i] == '(') {
                cek = false;
            } else if (arr[i] == ')') {
                cek = true;
            } else {
                System.out.print(arr[i]);
            }
        }
        data.tampil();
    }
}
