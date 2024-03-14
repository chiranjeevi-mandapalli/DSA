package com.chiru.linked_list.doubly_circular_linked_list;

/**
 * @author Chiranjeevi
 */
public class Node {
    int data;
    Node previous;
    Node next;

    public Node(int data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }
}
