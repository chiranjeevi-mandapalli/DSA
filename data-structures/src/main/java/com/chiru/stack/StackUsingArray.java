package com.chiru.stack;

/**
 * @author Chiranjeevi
 */
public class StackUsingArray {
    static int top = -1;

    private static void push(int data, int[] stack) {
        if (top == stack.length - 1) {
            System.out.println("Over flow");
            return;
        }
        top++;
        stack[top] = data;
    }

    private static void pop(int[] stack) {
        if (top == -1) {
            System.out.println("Under flow");
            return;
        }
        System.out.println("Element poped: " + stack[top]);
        stack[top] = 0;
        top--;
    }

    private static void peek(int[] stack) {
        if (top == -1) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Peek element: " + stack[top]);
    }

    private static void display(int[] stack){
        for (int i = top; i >=0 ; i--) {
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int N = 5; //size of stack
        int[] stack = new int[N];
        push(5,stack);
        push(6,stack);
        push(7,stack);
        display(stack);
        pop(stack);
        peek(stack);
        display(stack);
    }

}
