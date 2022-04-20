package LC2;

import java.util.Scanner;

class Node {

    Object data;
    Node next;

    Node() {
    }

    Node(Object data) {
        this.data = data;
    }

    Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

}

class Queue {

    int size = 0;
    Node front, rear;

    public Queue() {
        front = rear = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    void addFront(Object input) {
        Node temp = new Node(input);
        if (isEmpty()) {
            front = temp;
            rear = temp;
        } else {
            temp.next = front;
            front = temp;
        }
        size++;
    }

    void addBack(Object input) {
        Node temp = new Node(input);
        if (isEmpty()) {
            front = temp;
            rear = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
        size++;
    }

    void removeBack() {
        Node temp = front;
        if (!isEmpty()) {
            if (rear == front) {
                front = rear = null;
            } else {
                while (temp.next != rear) {
                    temp = temp.next;
                }
                temp.next = null;
                rear = temp;
                temp = null;
            }
            size--;
        }
    }

    void removeFront() {
        if (!isEmpty()) {
            Node temp = front;
            if (rear == front) {
                front = rear = null;
            } else {
                front = temp.next;
                temp.next = null;
                temp = null;
            }
            size--;
        }
    }

    public void print() {
        System.out.println("masuk");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

    }

    public void front() {
        System.out.println(front.data);
    }

    public void back() {
        System.out.println(rear.data);
    }

}

public class Soal2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Queue antrian = new Queue();
        for (int i = 0; i <= n; i++) {
            String arr[] = input.nextLine().split(" ");
            switch (arr[0]) {
                case "addFront": {
                    antrian.addFront(arr[1]);
                }
                break;
                case "addBack": {
                    antrian.addBack(arr[1]);
                }
                break;
                case "front": {
                    antrian.front();
                }
                break;
                case "back": {
                    antrian.back();
                }
                break;
                case "print": {
                    antrian.print();
                }
                break;
                case "removeFront": {
                    antrian.removeFront();
                }
                break;
                case "removeBack": {
                    antrian.removeBack();
                }
                break;
                case "isEmpty": {
                    System.out.println(antrian.isEmpty());
                }
                break;

            }
        }
    }
}
