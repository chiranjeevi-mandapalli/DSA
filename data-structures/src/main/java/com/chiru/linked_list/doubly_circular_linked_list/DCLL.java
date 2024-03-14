package com.chiru.linked_list.doubly_circular_linked_list;


/**
 * @author Chiranjeevi
 */
public class DCLL {
    static Node head;

    private static void display(Node head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        Node current = head;
        while (current.next != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data + " ");
        System.out.print(current.next.data);
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
            head = new_node;
            new_node.next = new_node;
            new_node.previous = new_node;
            return;
        }

        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        new_node.previous = current;
        new_node.next = head;
        current.next = new_node;
        head.previous = new_node;
    }

    private static void insertAtBeg(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            new_node.next = new_node;
            new_node.previous = new_node;
            return;
        }
        new_node.next = head;
        new_node.previous = head.previous;
        head.previous.next = new_node;
        head.previous = new_node;
        head = new_node;
    }

    private static void insertAtPosition(int data, int position) {
        Node new_node = new Node(data);
        if (position > getLength()) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            insertAtBeg(data);
            return;
        }
        Node current = head;
        int i = 1;
        while (i < position - 1) {
            current = current.next;
            i++;
        }
        new_node.previous = current;
        new_node.next = current.next;
        current.next = new_node;
        new_node.next.previous = new_node;
    }

    private static void deleteFromBeg() {
        Node current = head;
        if (head == null) {
            System.out.println("[]");
            return;
        }
        head = current.next;
        head.previous = current.previous;
        current.previous.next = head;
        current = null;
    }

    private static void deleteFromEnd() {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        Node current = head;
        current = current.previous;
        current.previous.next = head;
        head.previous = current.previous;
        current = null;
    }

    private static void deleteFromPosition(int position) {
        Node current = head;
        if (head == null) {
            System.out.println("[]");
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
        int i = 1;
        while (i < position - 1) {
            current = current.next;
            i++;
        }
        Node temp = current.next;
        current.next = temp.next;
        temp.next.previous = current;
        temp = null;
    }


    public static void main(String[] args) {
        insertAtEnd(3);
        insertAtEnd(4);
        insertAtEnd(5);
        insertAtBeg(7);
        insertAtPosition(11, 2);
        insertAtPosition(80, 4);
        display(head);
        deleteFromBeg();
        display(head);
        deleteFromEnd();
        display(head);
        System.out.println("Length: " + getLength());
        deleteFromPosition(3);
        display(head);


    }

}
