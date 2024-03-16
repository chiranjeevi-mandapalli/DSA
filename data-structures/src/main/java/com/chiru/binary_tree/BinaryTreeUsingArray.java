package com.chiru.binary_tree;

/**
 * @author Chiranjeevi
 */
public class BinaryTreeUsingArray {
    static class ArrayInsertionForBinaryTree {
        String[] str = new String[5];

        private void setRoot(String value) {
            str[0] = value;
        }

        private void setLeft(String value, int root) {
            if (str[0] == null) {
                System.out.println("Insert root value");
                return;
            }
            int l = (2 * root) + 1;
            str[l] = value;
        }

        private void setRight(String value, int root) {
            if (str[0] == null) {
                System.out.println("Insert root value");
                return;
            }
            int r = (2 * root) + 2;
            str[r] = value;
        }

        private void display() {
            for (String s : str) {
                System.out.print(s + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        ArrayInsertionForBinaryTree binaryTree = new ArrayInsertionForBinaryTree();
        binaryTree.setRoot("a");
        binaryTree.setLeft("b", 0);
        binaryTree.setRight("c", 0);
        binaryTree.setLeft("d", 1);
        binaryTree.setRight("e", 1);
        binaryTree.display();

    }
}
