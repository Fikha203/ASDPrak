package Tugas2;

import java.util.Scanner;

/**
 *
 * @author HHR
 */
class Node {

    double data;
    Node next;

    Node() {
    }

    Node(double theData) {
        data = theData;
    }

    Node(double theData, Node theNext) {
        data = theData;
        next = theNext;
    }
}

class LL {

    Node head, tail;
    double size = 0;

    void inisialisasi() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }
        size++;
    }

    void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
        size++;
    }

    void insertAfter(double key, Node input) {
        //Tulis Kodemu disini
        Node current = head;
        while (current.data != key) {
            current = current.next;
        }
        input.next = current.next;
        current.next = input;
        size++;
    }

    void insertBefore(double key, Node input) {
        //Tulis Kodemu disini
        Node current = head;
        while (current.next.data != key) {
            current = current.next;
        }
        input.next = current.next;
        current.next = input;
        size++;
    }

    public double mean() {
        //Tulis Kodemu disini
        Node current = head;
        double count = 0;
        for (int i = 0; i < size; i++) {
            count += current.data;
            current = current.next;
        }
        return count / size;

    }

 
}

public class Ratain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LL list = new LL();
        int m = in.nextInt();
        in.nextLine();
        String arr[] = new String[3];
        for (int i = 0; i < m; i++) {
            arr = in.nextLine().split(" ");
            switch (arr[0]) {
                case "addFirst": {
                    list.addFirst(new Node(Integer.parseInt(arr[1])));
                }
                break;
                case "addLast": {
                    //Tulis Kodemu disini
                    list.addLast(new Node(Integer.parseInt(arr[1])));
                }
                break;
                case "insertAfter": {
                    //Tulis Kodemu disini
                    list.insertAfter(Integer.parseInt(arr[1]), new Node(Integer.parseInt(arr[2])));
                }
                break;
                case "insertBefore": {
                    //Tulis Kodemu disini
                    list.insertAfter(Integer.parseInt(arr[1]), new Node(Integer.parseInt(arr[2])));
                }
                break;
            }
        }
        System.out.printf("%.2f", list.mean());
        System.out.println("");
   
    }
}
