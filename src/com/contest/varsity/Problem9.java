package com.contest.varsity;

/**
 * Created by chyvn on 15-01-2017.
 */

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class LLNode {
    Node start;
    Node end;

    LLNode() {
        start = null;
        end = null;
    }
}

public class Problem9 {


    public static void main(String[] args) {
        int post[] = {0, 2, 4, 6, 5, 3, 8, 10, 9, 7}; //regular tree
        //int post[] = {10, 9, 8, 7}; right tree
        //int post[] = {7, 8, 9, 10}; left tree
        //int post[] = {2, 5, 6, 4, 8, 11, 9, 15, 20, 19, 12, 7}; // another regular tree.
        Node root = buildTree(post, 0, post.length - 1);
        print(root);
        System.out.println();
        LLNode list = null;
        list = makeLinked(root);
        Node head = list.start;
        printLinked(head);
    }

    public static void print(Node root) {
        if (root.left != null) print(root.left);
        System.out.print(root.data + " ");
        if (root.right != null) print(root.right);
    }

    public static Node buildTree(int post[], int min, int max) {
        Node root = new Node(post[max]);
        int localMin = min - 1;
        for (int i = max - 1; i >= min; i--) {
            if (post[i] < post[max]) {
                localMin = i;
                break;
            }
        }
        if (localMin != min - 1) root.left = buildTree(post, min, localMin);
        if (localMin + 1 != max) root.right = buildTree(post, localMin + 1, max - 1);
        return root;
    }

    public static LLNode makeLinked(Node root) {
        LLNode list = new LLNode();
        LLNode leftList = new LLNode();
        LLNode rightList = new LLNode();

        if (root.left != null) {
            leftList = makeLinked(root.left);
            root.left = leftList.end;
            leftList.end.right = root;
        } else list.start = root;

        if (root.right != null) {
            rightList = makeLinked(root.right);
            root.right = rightList.start;
            rightList.start.left = root;
        } else list.end = root;

        if (list.start == null) list.start = leftList.start;
        if (list.end == null) list.end = rightList.end;

        return list;
    }

    public static void printLinked(Node root) {
        do {
            System.out.print(root.data + " ");
            root = root.right;
        } while (root != null);
    }
}
