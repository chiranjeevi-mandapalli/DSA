package com.chiru.queue;

/**
 * @author Chiranjeevi
 */
public class QueueUsingStack {
    static int N = 5; //size of array
    static int[] stack1 = new int[N];
    static int count = 0;
    static int[] stack2 = new int[N];
    static int top1 = -1;
    static int top2 = -1;

    private static void enqueue(int data) {
        push1(data);
        count++;
    }

    private static void dequeue() {
        if (top1 == -1 && top2 == -1) {
            System.out.println("Queue is empty");
        } else {
            int i = 0;
            while (i < count) {
                push2(pop1());
                i++;
            }
            int popedElement = pop2();
            System.out.println("Element removed " + popedElement);
            count--;
            i = 0;
            while (i < count) {
                push1(pop2());
                i++;
            }
        }
    }

    private static void push1(int data) {
        if (top1 == -1) {
            top1 = 0;
            stack1[top1] = data;
            System.out.println(String.format("Element %s inserted", data));
            return;
        }
        if (top1 == N - 1) {
            System.out.println("Overflow");
            return;
        }
        stack1[++top1] = data;
        System.out.println(String.format("Element %s inserted", data));
    }

    private static void push2(int data) {
        if (top2 == -1) {
            top2 = 0;
            stack2[top2] = data;
            System.out.println(String.format("Element %s inserted", data));
            return;
        }
        if (top2 == N - 1) {
            System.out.println("Overflow");
            return;
        }
        stack2[++top2] = data;
        System.out.println(String.format("Element %s inserted", data));
    }

    private static int pop1() {
        if (top1 == -1) {
            System.out.println("Under flow");
            return -1;
        }
        System.out.println(String.format("Element %s is poped from stack1", stack1[top1]));
        return stack1[top1--];
    }

    private static int pop2() {
        if (top2 == -1) {
            System.out.println("Under flow");
            return -1;
        }
        System.out.println(String.format("Element %s is poped from stack2", stack2[top2]));
        return stack2[top2--];
    }

    private static void display() {
        if (top1 == -1) {
            System.out.println("Queue is empty");
            return;
        }
        int i = top1;
        while (i >= 0) {
            System.out.print(stack1[i] + " ");
            i--;
        }
        System.out.println();

    }

    private static boolean isFull() {
        return top1 == N - 1;
    }

    private static boolean isNull() {
        return top1 == -1;
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
        System.out.println("Is queue full: " + isFull());
        System.out.println("Is queue null: " + isNull());
    }

}
