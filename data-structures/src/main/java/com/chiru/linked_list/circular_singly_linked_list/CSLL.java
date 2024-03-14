package com.chiru.linked_list.circular_singly_linked_list;

/**
 * @author Chiranjeevi
 */
public class CSLL {
    static Node head;
    static Node tail;

    private static void display(Node head) {
        Node current = head;
        while (current.next != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }

    private static int getLength() {
        if (head == null) {
            return 0;
        } else {
            int len = 0;
            Node current = head;
            while (current.next != head) {
                current = current.next;
                len++;
            }
            return (len + 1);
        }
    }

    private static void insertAtEnd(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = tail = new_node;
            head.next = tail;
            return;
        }
        new_node.next = tail.next;
        tail.next = new_node;
        tail = new_node;
    }

    private static void insertAtBeg(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = tail = new_node;
            head.next = tail;
            return;
        }
        new_node.next = head;
        head = new_node;
        tail.next = head;
    }

    private static void insertAtPosition(int data, int pos) {
        Node new_node = new Node(data);
        if (head == null) {
            head = tail = new_node;
            head.next = tail;
            return;
        }
        if (pos > getLength()) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            insertAtBeg(data);
            return;
        }
        Node current = head;
        int i = 1;
        while (i < pos - 1) {
            i++;
            current = current.next;
        }
        new_node.next = current.next;
        current.next = new_node;
    }

    private static void deleteFromBeg() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (getLength() == 1) {
            head = tail = null;
            current = null;
            return;
        }
        head = current.next;
        tail.next = head;
        current = null;
    }

    private static void deleteFromEnd() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (getLength() == 1) {
            head = tail = null;
            current = null;
            return;
        }
        while (current.next != tail) {
            current = current.next;
        }
        current.next = head;
        Node temp = tail;
        tail = current;
        temp = null;
    }

    private static void deleteFromPosition(int position) {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) {
            deleteFromBeg();
            return;
        }
        if (position == getLength()) {
            deleteFromEnd();
            return;
        }
        int i= 1;
        while (i < position-1){
            i++;
            current = current.next;
        }
        Node temp = current.next;
        current.next = current.next.next;
        temp = null;
    }

    public static void main(String[] args) {
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        display(head);
        System.out.println("Length: " + getLength());
        insertAtBeg(1);
        insertAtBeg(5);
        display(head);
        insertAtPosition(15, 3);
        display(head);
        deleteFromBeg();
        display(head);
        deleteFromEnd();
        display(head);
        deleteFromPosition(2);
        display(head);
    }

}
