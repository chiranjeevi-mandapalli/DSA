package com.chiru.b_tree;

/**
 * @author Chiranjeevi
 */
public class Node {
    Node parent;
    Node[] children;
    int[] data;
    boolean leaf;
    int size;

    //m is order
    public Node(int m) {
        data = new int[(2 * m) - 1];
        children = new Node[2 * m];
        this.parent = null;
        this.leaf = true;
        this.size = 0;
    }
}
