package com.chiru.binary_search_tree;

/**
 * @author Chiranjeevi
 */
public class BST {
    static Node root;

    private static void insert(int data) {
        Node new_node = new Node(data);
        if (root == null) {
            root = new_node;
            return;
        }
        if (data > root.data) {
            if (root.right == null) {
                root.right = new_node;
                return;
            }
            Node current = root.right;
            setdata(current, data, new_node);
        } else {
            if (root.left == null) {
                root.left = new_node;
                return;
            }
            Node current = root.left;
            setdata(current, data, new_node);
        }
    }

    private static void setdata(Node current, int data, Node new_node) {
        while (current != null) {
            if (data > current.data) {
                if (current.right != null) {
                    current = current.right;
                } else {
                    current.right = new_node;
                    current = null;
                }
            } else {
                if (current.left != null) {
                    current = current.left;
                } else {
                    current.left = new_node;
                    current = null;
                }
            }
        }
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        insert(100);
        insert(50);
        insert(200);
        insert(40);
        insert(60);
        insert(150);
        insert(250);
        preOrder(root);
    }
}
