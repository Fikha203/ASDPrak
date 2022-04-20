package SLL;

class Node {

    double data;
    Node next;

    Node() {
    }

    ;
    Node(double data) {
        this.data = data;
    }
}

public class LL {

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

    public void cetak() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
//        LL list = new LL();
//        list.addFirst(new Node("a"));
//        list.addLast(new Node("i"));
//        list.addFirst(new Node("h"));
//        list.addLast(new Node("c"));
//        list.insertAfter("i", new Node("m"));
//        list.addFirst(new Node("h"));
//        list.insertAfter("a", new Node("k"));
//        list.removeFirst();
//        list.removeLast();
//        list.cetak();
    }

}
