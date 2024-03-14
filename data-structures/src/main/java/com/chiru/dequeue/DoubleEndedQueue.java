package com.chiru.dequeue;

/**
 * @author Chiranjeevi
 */
public class DoubleEndedQueue {
    static int N = 5; //size of array
    static int[] dequeue = new int[N];
    static int front = -1;
    static int rear = -1;

    private static void enqueue(int data) {
        if ((front == 0 && rear == (N - 1)) || front == rear + 1) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1 && rear == -1) {
            front = rear = 0;
            dequeue[front] = data;
            return;
        }
        if (front == 0) {
            front = N - 1;
            dequeue[front] = data;
            return;
        }
        front--;
        dequeue[front] = data;
    }

    private static void dequeueFront() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        if (front == rear) {
            System.out.println("Element removed from queue is " + dequeue[front]);
            front = rear = -1;
            return;
        }
        if (front == N - 1) {
            System.out.println("Element removed from queue is " + dequeue[front]);
            front = 0;
            return;
        }
        front++;
    }

    private static void enqueueRear(int data) {
        if ((front == 0 && rear == (N - 1)) || front == rear + 1) {
            System.out.println("Queueu is full");
            return;
        }
        if (front == -1 && rear == -1) {
            front = rear = 0;
            dequeue[rear] = data;
            return;
        }
        if (rear == N - 1) {
            rear = 0;
            dequeue[rear] = data;
            return;
        }
        rear++;
        dequeue[rear] = data;

    }

    private static void dequeueRear() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        if (front == rear) {
            System.out.println("Element removed from queue is " + dequeue[rear]);
            front = rear = -1;
            return;
        }
        if (rear == 0) {
            System.out.println("Element removed from queue is " + dequeue[rear]);
            rear = N-1;
            return;
        }
        rear--;
    }

    private static void display() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        while (i != rear) {
            System.out.print(dequeue[i] + " ");
            i = (i + 1) % N;
        }
        System.out.print(dequeue[rear]);
        System.out.println();

    }


    public static void main(String[] args) {
        enqueue(5);
        enqueue(6);
        enqueue(7);
        enqueue(8);
        enqueue(9);
        display();

    }
}
