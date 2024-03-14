package com.chiru.stack;

/**
 * @author Chiranjeevi
 */
public class StackUsingLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node top = null;

    private static void push(int data) {
        Node new_node = new Node(data);
        new_node.next = top;
        top = new_node;

    }

    private static void pop() {
        Node current = top;
        top = current.next;
        current = null;

    }

    private static void peek() {
        System.out.println("Peek element: " + top.data);
    }

    private static void display() {
        Node current = top;
        while (current.next != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.print(current.data);
        System.out.println();
    }

    public static void main(String[] args) {
        push(5);
        push(6);
        push(7);
        display();
        pop();
        display();
        peek();
    }


}
