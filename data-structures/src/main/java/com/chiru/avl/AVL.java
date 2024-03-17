package com.chiru.avl;

/**
 * @author Chiranjeevi
 */
public class AVL {
    private Node root = null;

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int updateHeight(Node node) {
        return node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rightRotate(Node z) {
        Node y = z.left;
        Node T3 = y.right;
        y.right = z;
        z.left = T3;
        z.height = updateHeight(z);
        y.height = updateHeight(y);
        return y;
    }

    private Node leftRotate(Node z) {
        Node y = z.right;
        Node T2 = y.left;
        y.left = z;
        z.right = T2;
        z.height = updateHeight(z);
        y.height = updateHeight(y);
        return y;
    }

    private Node reBalance(Node node, int key) {
        updateHeight(node);
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key < key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }
        return reBalance(node, key);
    }

    private Node delete(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null || root.right == null) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }

                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }
        if (root == null) {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    private Node find(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null)
            current = current.left;

        return current;
    }

    // inorderPredecessor --> largest lement in the left subtree
    // inOrdersuccessor --> smallest element in the right subtree
    Node inOrderPredecessor(Node node) {
        if (node.left != null) {
            Node current = node.left;
            while (current.right != null) {
                current = current.right;
            }
            return current;
        } else {
            return node;
        }
    }

    Node inOrderSuccessor(Node node) {
        return node.right != null ? node.right : node;
    }

    Node maxValueNode(Node node) {
        Node current = node;
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.root = tree.insert(tree.root, 9);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 0);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 11);
        tree.root = tree.insert(tree.root, -1);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 2);
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
        System.out.println();
//        System.out.println(tree.find(10));
//        System.out.println(tree.minValueNode(tree.root).key);
//        System.out.println(tree.maxValueNode(tree.root).key);
//        System.out.println(tree.inOrderPredecessor(tree.root).key);
//        System.out.println(tree.inOrderSuccessor(tree.root).key);
//        System.out.println(tree.root.height);
        tree.root = tree.delete(tree.root,10);
        tree.preOrder(tree.root);
    }
}
