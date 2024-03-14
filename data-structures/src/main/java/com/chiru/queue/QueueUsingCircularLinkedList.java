package com.chiru.queue;

/**
 * @author Chiranjeevi
 */
public class QueueUsingCircularLinkedList {
    static Node front;// we always use for deleteion
    static Node rear; // we always use for insertion

    private static void enqueue(int data) {
        Node new_node = new Node(data);
        if (rear == null && front == null) {
            front = rear = new_node;
            new_node.next = front;
            System.out.println(String.format("Element %s inserted", data));
        } else {
            rear.next = new_node;
            new_node.next = front;
            rear = new_node;
            System.out.println(String.format("Element %s inserted", data));
        }
    }

    private static void dequeue() {
        if (rear == null && front == null) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            Node current = front;
            System.out.println(String.format("Element %s is removed from queue", current.data));
            front = null;
            rear = null;
            current = null;
        } else {
            Node current = front;
            front = current.next;
            rear.next = front;
            System.out.println(String.format("Element %s is removed from queue", current.data));
            current = null;
        }

    }

    private static void display() {
        if (rear == null && front == null) {
            System.out.println("Queue is empty");
        } else {
            Node current = front;
//            while (current.next != front) {
//                System.out.print(current.data + " ");
//                current = current.next;
//            }
//            System.out.print(current.data + " ");
//            System.out.print(current.next.data);
//            System.out.println();
            System.out.print(current.data + " ");
            do {
                current = current.next;
                System.out.print(current.data + " ");
            } while (current.next != front);
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
        enqueue(7);
        enqueue(8);
        display();
        dequeue();
        dequeue();
        dequeue();
        display();
        enqueue(9);
        enqueue(10);
        enqueue(11);
        display();
        System.out.println("Peek element: " + front());
        System.out.println("Rear element: " + rear());
        System.out.println("Is queue null: " + isNull());
    }
}
