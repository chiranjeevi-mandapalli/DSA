package com.chiru.queue;

/**
 * @author Chiranjeevi
 */
public class QueueUsingArray {
    static int N = 5; //size of array
    static int[] queue = new int[N];
    static int front = -1; // we always use for deleteion
    static int rear = -1; // we always use for insertion

    private static void enqueue(int data) {
        if (front == -1 || rear == -1) {
            front = rear = 0;
            queue[rear] = data;
            System.out.println(String.format("Element %s inserted", data));
            return;
        }
        if (rear == N - 1) {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        queue[rear] = data;
        System.out.println(String.format("Element %s inserted", data));
    }

    private static void dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty");
            return;
        }
        if (front == rear) {
            System.out.println(String.format("Element %s is removed from queue", queue[front]));
            front = rear = -1;
            return;
        }
        System.out.println(String.format("Element %s is removed from queue", queue[front]));
        front++;

    }

    private static void display() {
        if (front == -1 || rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        while (i < rear) {
            System.out.print(queue[i] + " ");
            i++;
        }
        System.out.print(queue[rear]);
        System.out.println();

    }

    //return the first elelment of the queue without deleting it.
    private static int front() {
        if (front == -1 || rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    //    returns the element at the rear end without removing it.
    private static int rear() {
        if (front == -1 || rear == -1) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[rear];
    }

    private static boolean isFull() {
        return rear == N - 1;
    }

    private static boolean isNull() {
        return front == -1;
    }

    public static void main(String[] args) {
        System.out.println("Is queue null: " + isNull());
        enqueue(5);
        enqueue(6);
        enqueue(7);
        enqueue(8);
        enqueue(9);
        display();
        dequeue();
        display();
        System.out.println("Peek element: "+front());
        System.out.println("Rear element: "+rear());
        System.out.println("Is queue full: " + isFull());
        System.out.println("Is queue null: " + isNull());
    }
}
