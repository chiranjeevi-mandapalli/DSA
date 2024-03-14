package com.chiru.linked_list.singly_linked_list;

/**
 * @author Chiranjeevi
 */
public class SLLImpl {
    Node head;

    public SLLImpl() {
        this.head = null;
    }

    private void add(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new_node;
        }
    }

    private void insertAtBeg(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;
    }

    private void insertAtEnd(int data) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new_node;

    }

    private void insertAtPosition(int data, int position) {
        Node new_node = new Node(data);
        if (head == null) {
            head = new_node;
            return;
        }
        if (position > getLength()) {
            System.out.println("Invalid position");
            return;
        }
        int i = 1;
        if (position == 1) {
            insertAtBeg(data);
            return;
        }
        Node current = head;
        while (i < position - 1) {
            i++;
            current = current.next;
        }
        new_node.next = current.next;
        current.next = new_node;
    }

    private void deleteFromBegining() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        head = head.next;
        temp = null;
    }

    private void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    private void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) {
            deleteFromBegining();
            return;
        }
        if (position == getLength()) {
            deleteFromEnd();
            return;
        }
        int i = 1;
        Node current = head;
        while (i < position - 1) {
            current = current.next;
            i++;
        }
        Node temp = current.next;
        current.next = current.next.next;
        temp = null;

    }

    private int getLength() {
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

    private void display() {
        Node current = head;
        while (current.next != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }

    public static void main(String[] args) {
        SLLImpl sll = new SLLImpl();
        sll.add(4);
        sll.add(7);
        sll.display();
        sll.insertAtBeg(3);
        sll.display();
        sll.insertAtEnd(8);
        sll.display();
        System.out.println("Length: " + sll.getLength());
        sll.insertAtPosition(10, 3);
        sll.display();
//        sll.deleteFromBegining();
//        sll.display();
//        sll.deleteFromEnd();
//        sll.display();
        sll.deleteFromPosition(2);
        sll.display();


    }

}
