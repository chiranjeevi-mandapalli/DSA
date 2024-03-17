package com.chiru.red_black_tree;

/**
 * @author Chiranjeevi
 */
public class Node {
    int data;
    Node left;
    Node right;
    Node parent;
    char color;

    public Node(int data, char color){
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.color = color;
    }
}
