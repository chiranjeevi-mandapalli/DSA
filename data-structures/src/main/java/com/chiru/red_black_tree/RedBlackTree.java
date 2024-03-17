package com.chiru.red_black_tree;

/**
 * @author Chiranjeevi
 */
public class RedBlackTree{
    static Node root;
    public static Node makeNode(int data){
        Node node = new Node(data,'R');
        node.left = new Node(-1,'B');
        node.right = new Node(-1,'B');
        return node;
    }
    public static void add(int data){
        System.out.println("Inserting data : " + data);
        Node node = makeNode(data);
        if(root == null){
            root = node;
            root.color = 'B';
            return;
        }

        Node temp = root;
        while(temp!=null){
            if(temp.data>data){
                if(temp.left.data==-1){
                    temp.left = node;
                    node.parent = temp;
                    balance(node);
                    return;
                }
                temp = temp.left;
                continue;
            }
            if(temp.data<data){
                if(temp.right.data==-1){
                    temp.right = node;
                    node.parent = temp;
                    balance(node);
                    return;
                }
                temp = temp.right;
            }
        }
    }
    public static void remove(int data){
        System.out.println("Remove data : " + data);
        if(root==null){
            return;
        }
        Node temp = root;
        while(temp.data!=-1){
            if(temp.data==data){
                break;
            }
            if(temp.data>data){
                temp = temp.left;
                continue;
            }
            if(temp.data<data){
                temp = temp.right;
                continue;
            }
        }
        if(temp.data==-1){
            return;
        }
        Node next = findNext(temp);

        int t = temp.data;
        temp.data = next.data;
        next.data = t;
        Node parent = next.parent;
        if(parent==null){
            if(next.left.data==-1){
                root = null;
            }
            else{
                root = next.left;
                next.parent = null;
                root.color = 'B';
            }
            return;
        }

        if(parent.right==next){
            parent.right = next.left;
        }
        else{
            parent.left = next.left;
        }
        next.left.parent = parent;
        String color = Character.toString(next.left.color) +  Character.toString(next.color);
        balance(next.left,color);
    }
    private static void balance(Node node, String color){
        System.out.println("Balancing Node : " + node.data + " Color : " + color);

        if(node.parent==null || color.equals("BR") || color.equals("RB")){
            node.color = 'B';
            return;
        }

        Node parent = node.parent;
        Node sibling = null;
        if(parent.left==node){
            sibling = parent.right;
        }
        else{
            sibling = parent.left;
        }


        Node sibleft = sibling.left;
        Node sibright = sibling.right;

        if(sibling.color=='B' && sibleft.color=='B' && sibright.color=='B'){
            sibling.color = 'R';
            node.color = 'B';
            String c = Character.toString(parent.color) + Character.toString('B');
            balance(parent,c);
            return;
        }
        if(sibling.color=='R'){
            if(parent.right==sibling){
                leftRotate(sibling);
            }
            else{
                rightRotate(sibling);
            }
            balance(node,color);
            return;
        }
        if(parent.left==sibling){
            if(sibleft.color =='R'){
                rightRotate(sibling);
                sibleft.color = 'B';
            }
            else{
                leftRotate(sibright);
                rightRotate(sibright);
                sibright.left.color = 'B';
            }
            return;
        }
        else{
            if(sibright.color == 'R'){
                leftRotate(sibling);
                sibright.color = 'B';
            }
            else{
                rightRotate(sibleft);
                leftRotate(sibleft);
                sibleft.right.color= 'B';
            }
            return;
        }
    }
    private static Node findNext(Node node){
        Node next = node.right;
        if(next.data==-1){
            return node;
        }
        while(next.left.data!=-1){
            next = next.left;
        }
        return next;
    }
    public static void balance(Node node){
        System.out.println("Balancing Node : " + node.data);
        if(node.parent == null){
            root = node;
            root.color = 'B';
            return;
        }

        if(node.parent.color=='B'){
            return;
        }
        Node sibling = null;
        if(node.parent.parent.left == node.parent){
            sibling = node.parent.parent.right;
        }
        else{
            sibling = node.parent.parent.left;
        }
        if(sibling.color == 'R'){
            node.parent.color = 'B';
            sibling.color = 'B';
            node.parent.parent.color = 'R';
            balance(node.parent.parent);
            return;
        }
        else{
            if(node.parent.left == node && node.parent.parent.left == node.parent){
                rightRotate(node.parent);
                balance(node.parent);
                return;
            }
            if(node.parent.right == node && node.parent.parent.right == node.parent){
                leftRotate(node.parent);
                balance(node.parent);
                return;
            }
            if(node.parent.right == node && node.parent.parent.left == node.parent){
                leftRotate(node);
                rightRotate(node);
                balance(node);
                return;
            }
            if(node.parent.left == node && node.parent.parent.right == node.parent){
                rightRotate(node);
                leftRotate(node);
                balance(node);
                return;
            }
        }
    }
    private static void leftRotate(Node node){
        System.out.println("Rotating left  : "  + node.data);
        Node parent = node.parent;
        Node left = node.left;
        node.left = parent;
        parent.right = left;
        if(left!=null){
            left.parent = parent;
        }
        char c = parent.color;
        parent.color = node.color;
        node.color = c;
        Node gp = parent.parent;
        parent.parent = node;
        node.parent = gp;

        if(gp==null){
            root = node;
            return;
        }
        else{
            if(gp.left == parent){
                gp.left = node;
            }
            else{
                gp.right = node;
            }
        }
    }
    private static void rightRotate(Node node){
        System.out.println("Rotating right : " + node.data);
        Node parent = node.parent;
        Node right = node.right;
        node.right = parent;
        parent.left = right;
        if(right!=null){
            right.parent = parent;
        }
        char c = parent.color;
        parent.color = node.color;
        node.color = c;
        Node gp = parent.parent;
        parent.parent = node;
        node.parent = gp;

        if(gp==null){
            root = node;
            return;
        }
        else{
            if(gp.left == parent){
                gp.left = node;
            }
            else{
                gp.right = node;
            }
        }
    }
    private static void preOrder(Node node){
        if(node.data==-1){
            return;
        }
        System.out.print(node.data + "-" + node.color + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void display(){
        if(root == null){
            System.out.println("Empty Tree");
            return;
        }

        System.out.print("Tree's PreOrder Traversal : ");
        preOrder(root);
        System.out.println();
    }
    public static void main(String [] args){
        add(10);
        display();

        add(5);
        display();

        add(30);
        display();

        add(1);
        display();

        add(7);
        display();

        add(20);
        display();

        add(38);
        display();

        add(35);
        display();

        add(8);
        display();

        remove(20);
        display();

        remove(30);
        display();

        remove(35);
        display();

        remove(1);
        display();
    }
}

