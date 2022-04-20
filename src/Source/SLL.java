/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Source;

class Node {

    double data;
    Node next;
    Node(double data){
        this.data = data;
    }
}

class LL {

    Node head, tail;
    int size = 0;

    public LL() {
        this.inisialisasi();
    }

    void inisialisasi() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    int size() {
        return size;
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

    void removeFirst() {
        Node temp = head;
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                temp = temp.next;
                head = temp;
                temp = null;
            }
            size--;
        } else {
            System.out.println("Data is empty!");
        }
    }

    void removeLast() {
        Node temp = head;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                temp = null;
            }
            size--;
        } else {
            System.out.println("Data is empty!");
        }
    }

    void remove(Object key) {
        Node temp = head, hapus = null;
        if (isEmpty()) {
            System.out.println("Data is empty");
        } else {
//            while ((int) temp.data != (int) key) {
//                nextPointer = temp.next.next;
//                temp = temp.next;
//            }
//            temp = head;
//            while (temp.next != null) {
//                if ((int) temp.next.data == (int) key) {
//
//                    temp.next = nextPointer;
//                    size--;
//                    break;
//                }
//                temp = temp.next;
//            }
            while(temp != null){
                if((int)temp.next.data == (int) key){
                    hapus = temp.next;
                    temp.next = hapus.next;
                    hapus.next = null;
                    hapus = null;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void cetakLinkedlist() {
        Node temp = head;
        int x = 0;
        while (temp != null) {
            System.out.println("DataIndex-" + x + "  :" + temp.data);
            temp = temp.next;
            x++;
        }
    }
}

public class SLL {
    public static void main(String[] args) {
        LL benda = new LL();
        benda.addFirst(new Node(1));
        benda.addFirst(new Node(2));
        benda.addFirst(new Node(3));
        benda.cetakLinkedlist();
        benda.remove(2);
        benda.cetakLinkedlist();
    }
}
