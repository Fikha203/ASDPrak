/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan;

import java.util.Scanner;

/**
 *
 * @author HHR
 */
class Node {

    int value;
    Node next;

    Node(int userEntry) {
        this.value = userEntry;
    }
}

class StackScratch {

    int length = 0;
    int jarakDitempuh = 0;
    Node top;

    void pushNewNode(Node newNode) {
        if (length != 0) {
            newNode.next = top;
        }
        top = newNode;
        length++;
    }

    void popNode() {
        if (length == 0) {
            return;
        }
        if (length == 1) {
            top = null;
        } else {
            Node temp = top;
            top = temp.next;
            temp.next = null;
        }
        length--;
    }

    void displayStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print((temp.next != null) ? temp.value + "->" : temp.value + "\n");
            temp = temp.next;
        }
    }

    int popNodeWithValue() {
        if (length == 0) {
            return 0;
        }
        Node temp = top;
        if (length == 1) {
            top = null;
        } else {
            top = temp.next;
            temp.next = null;
        }
        length--;
        return temp.value;
    }

    int uangBensinYangDigunakan(int totalJarak) {
        //Isi sendiri
        return 1000 * totalJarak;
    }

    void popAllStacks() {
        //Isi sendiri
        Node current = top;
        int jarak = 0;
        while (current != null) {
            jarak += current.value;
            current = current.next;
        }
        this.jarakDitempuh = jarak;
    }

    int getJarakDitempuh() {
        //Isi sendiri
        return this.jarakDitempuh;
    }

    void resetJarakDitempuh() {
        //Isi sendiri
        this.jarakDitempuh = 0;
    }
}

public class isiBensin {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCase = in.nextInt();
        int uangUntukBensin = in.nextInt();
        StackScratch stack = new StackScratch();
        in.nextLine();
        for (int i = 0; i < testCase; i++) {
            String nextInput = in.nextLine();
            if (nextInput.charAt(0) == 'B') {
                stack.popAllStacks();
                uangUntukBensin -= stack.uangBensinYangDigunakan(stack.getJarakDitempuh());
                stack.resetJarakDitempuh();
            } else {
                stack.pushNewNode(new Node(Integer.parseInt(nextInput)));
            }
        }
        System.out.println(uangUntukBensin);
    }
}
