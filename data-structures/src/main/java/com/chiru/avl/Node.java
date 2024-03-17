package com.chiru.avl;

/**
 * @author Chiranjeevi
 */
public class Node {
    //    In an AVL Tree, the balance factor of a node could be only one of 1, 0, or -1 values.
    int key;
    int height;
    Node left;
    Node right;

    public Node(int key) {
        this.key = key;
        height = 1;
        left = null;
        right = null;
    }

}
