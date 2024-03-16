package com.chiru.binary_tree;

/**
 * @author Chiranjeevi
 */
public class BinaryTree {
    private static Node root = null;

    private static void insert() {
        if (root == null) {
            root = new Node(5);
        }
        root.left = new Node(10);
        root.left.left = new Node(15);
        root.left.right = new Node(20);

        root.right = new Node(12);
        root.right.left = new Node(25);
        root.right.right = new Node(30);
    }

    private static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    private static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static void main(String[] args) {
        insert();
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }
}
