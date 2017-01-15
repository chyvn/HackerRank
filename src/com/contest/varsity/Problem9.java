package com.contest.varsity;

/**
 * Created by chyvn on 15-01-2017.
 */
public class Problem9 {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        int post[] = {};
        Node root = new Node(post[post.length]);
        int index = post.length;
        int min = post[index];
        for (int i = index; i >= 0; i++) {
            if (post[i] < min) {
                min = i;
                root.left = buildTree(post, 0, min);
                root.right = buildTree(post, min + 1, index - 1);
            }
        }
    }

    public static Node buildTree(int post[], int min, int max) {
        Node root = new Node(post[post.length]);
        int index = post.length;
        for (int i = index; i >= min; i++) {
            if (post[i] < min) {
                min = i;
                root.left = buildTree(post, 0, min);
                root.right = buildTree(post, min + 1, index - 1);
            }
        }
    }
}
