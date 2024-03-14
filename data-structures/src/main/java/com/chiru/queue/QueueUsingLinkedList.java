package com.chiru.queue;

/**
 * @author Chiranjeevi
 */
public class QueueUsingLinkedList {
    static Node front;// we always use for deleteion
    static Node rear; // we always use for insertion

    private static void enqueue(int data) {
        Node new_node = new Node(data);
        if (rear == null && front == null) {
            front = rear = new_node;
            System.out.println(String.format("Element %s inserted", data));
        } else {
            rear.next = new_node;
            rear = new_node;
            System.out.println(String.format("Element %s inserted", data));
        }
    }

    private static void dequeue() {
        if (rear == null && front == null) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            System.out.println(String.format("Element %s is removed from queue", front.data));
            front = rear = null;
        } else {
            Node current = front;
            front = front.next;
            System.out.println(String.format("Element %s is removed from queue", current.data));
            current = null;
        }

    }

    private static void display() {
        if (rear == null && front == null) {
            System.out.println("Queue is empty");
        } else {
            Node current = front;
            do {
                System.out.print(current.data + " ");
                current = current.next;
            } while (current.next != null);
            System.out.print(current.data);
            System.out.println();
        }

    }

    //return the first elelment of the queue without deleting it.
    private static int front() {
        if (rear == null && front == null) {
            return -1;
        }
        return front.data;
    }

    //    returns the element at the rear end without removing it.
    private static int rear() {
        if (rear == null && front == null) {
            return -1;
        }
        return rear.data;
    }

    private static boolean isNull() {
        return front == null;
    }

    public static void main(String[] args) {
        System.out.println("Is queue null: " + isNull());
        enqueue(5);
        enqueue(6);
        display();
        dequeue();
        dequeue();
        dequeue();
        display();
        System.out.println("Peek element: " + front());
        System.out.println("Rear element: " + rear());
        System.out.println("Is queue null: " + isNull());
    }
}
