package com.chiru.linked_list.doubly_linked_list;

/**
 * @author Chiranjeevi
 */
public class DLL {
    static Node head;
    static Node tail;

    private static void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = tail = new_node;
            return;
        }
        tail.next = new_node;
        new_node.previous = tail;
        tail = new_node;

    }

    private static void insertAtBeg(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = tail = new_node;
            return;
        }
        new_node.next = head;
        head.previous = new_node;
        head = new_node;

    }

    private static void insertAtPosition(int data, int position) {
        Node new_node = new Node(data);
        if (head == null) {
            head = tail = new_node;
            return;
        }
        if (position > getLength()) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            insertAtBeg(data);
            return;
        }
        int i = 1;
        Node current = head;
        while (i < position - 1) {
            i++;
            current = current.next;
        }
        new_node.previous = current;
        new_node.next = current.next;
        current.next.previous = new_node;
        current.next = new_node;

    }

    private static void insertAfterPosition(int data, int position) {
        Node new_node = new Node(data);
        if (head == null) {
            head = tail = new_node;
            return;
        }
        if (position == 1) {
            insertAtBeg(data);
            return;
        }
        if (position == getLength()) {
            add(data);
        }
        int i = 1;
        Node current = head;
        while (i < position) {
            i++;
            current = current.next;
        }
        new_node.previous = current;
        new_node.next = current.next;
        current.next.previous = new_node;
        current.next = new_node;

    }

    private static void insertBeforePosition(int data, int position) {
        Node new_node = new Node(data);
        if (head == null) {
            head = tail = new_node;
            return;
        }
        if (position == 1) {
            insertAtBeg(data);
            return;
        }
        if (position == getLength()) {
            add(data);
        }
        int i = 1;
        Node current = head;
        while (i < position - 2) {
            i++;
            current = current.next;
        }
        new_node.previous = current;
        new_node.next = current.next;
        current.next.previous = new_node;
        current.next = new_node;

    }

    private static void deleteFrombeg() {
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
        current.next.previous = null;
        head = current.next;
        current = null;
    }

    private static void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = tail;
        if (getLength() == 1) {
            head = tail = null;
            current = null;
            return;
        }
        current.previous.next = null;
        tail = current.previous;
        current = null;

    }

    private static void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position > getLength()) {
            System.out.println("Invalid position");
            return;
        }
        if (position == 1) {
            deleteFrombeg();
            return;
        }
        if (position == getLength()) {
            deleteFromEnd();
            return;
        }
        Node current = head;
        int i = 1;
        while (i < position - 1) {
            i++;
            current = current.next;
        }
        Node temp = current;
        temp = temp.next;
        current.next = current.next.next;
        current.next.previous = current;
        temp = null;
    }

    private static void display(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }

    private static void traverseForward() {
        System.out.println("----Forward traversal----");
        System.out.println();
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data + " ");
        System.out.println();

    }

    private static void traverseBackWard() {
        System.out.println("----Backward traversal----");
        System.out.println();
        Node current = tail;
        if(tail == null){
            System.out.println("List is empty");
            return;
        }
        while (current.previous != null) {
            System.out.print(current.data + " ");
            current = current.previous;
        }
        System.out.print(current.data + " ");
        System.out.println();
    }

    private static int getLength() {
        if (head == null) {
            return 0;
        } else {
            int len = 0;
            Node current = head;
            while (current.next != null) {
                current = current.next;
                len++;
            }
            return (len + 1);
        }
    }

    public static void main(String[] args) {
        add(5);
        add(10);
        add(15);
        display(head);
        System.out.println("Length: " + getLength());
        insertAtBeg(8);
        insertAtBeg(13);
        display(head);
        insertAtPosition(50, 2);
        display(head);
        insertAfterPosition(70, 3);
        display(head);
        insertBeforePosition(3, 2);
        display(head);
        deleteFrombeg();
        display(head);
        deleteFromEnd();
        display(head);
        deleteFromPosition(2);
        display(head);
        traverseForward();
        traverseBackWard();
    }

}
