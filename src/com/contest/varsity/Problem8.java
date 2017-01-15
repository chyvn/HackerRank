package com.contest.varsity;

import java.util.Arrays;

/**
 * Created by chyvn on 14-01-2017.
 */

public class Problem8 {
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
        int post[] = {3, 5, 6, 2, 9, 11, 1, 7};
        int inorder[] = new int[post.length];
        for (int i = 0; i < post.length; i++) inorder[i] = post[i];
        Arrays.sort(inorder);
        for (int i = 0; i < post.length; i++) System.out.print(inorder[i] + " " + post[i] + " ");
        Node root = null;
        root = buildTree(inorder, post, root, 0);
        print(root);
    }

    public static void print(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) print(root.left);
        if (root.right != null) print(root.right);
    }

    public static Node buildTree(int[] inorder, int[] post, Node temp, int direction) {
        int thisNode = post[post.length];
        Node local = new Node(thisNode);
        if (temp == null) temp = local;
        else {
            if (direction  == 1) temp.left = local;
            else temp.right = local;
        }

        int index = 0;
        for (int i = 0; i < inorder.length; i++) if (inorder[i] == thisNode) index = i;

        int leftInorder[];int leftPost[];
        int rightInorder[];int rightPost[];
        if (index > 0) {
            leftInorder = Arrays.copyOfRange(inorder, 0, index - 1);
            leftPost = Arrays.copyOfRange(post, 0, leftInorder.length);
            buildTree(leftInorder, leftPost, local, 1);

        }
        if (index != inorder.length) {
            rightInorder = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            rightPost = Arrays.copyOfRange(post, post.length - rightInorder.length, post.length);
            buildTree(rightInorder, rightPost, local, 2);

        }

        return temp;
    }


}
