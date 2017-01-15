package com.contest.varsity;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by chyvn on 10-01-2017.
 * <p>
 * The program creates an n ary tree, which means a node can have as many as n children.
 * <p>
 * In this we've to find the longest path.
 * <p>
 * Input :
 * line 1 : number of nodes.
 * Line 2 : Children of each node in ascending order
 * Line 3 : it no children empty line.
 */
public class Problem7 {
    public static class Node {
        String data;
        List<Node> children = new ArrayList<>();
        Node parent;

        Node(String data) {
            this.data = data;
            parent = null;
        }

        void putChild(Node node) {
            children.add(node);
            node.parent = this;
        }

        List getChildren() {
            return children;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node> tree = new ArrayList<>();
        while (n > 0) {
            --n;
            String input = scanner.nextLine();
            String[] a = input.split(" ");
            String root = a[0];
            Node temp = new Node(root);
            tree.add(temp);
            for (int i = 1; i < a.length; i++) {
                temp.putChild(new Node(a[i]));
            }
        }


//        for (int i = 0; i < tree.size(); i++) {
//            System.out.print(tree.get(i).data + " : ");
//            List<Node> temp = tree.get(i).getChildren();
//            for (int j = 0; j < temp.size(); j++)
//                System.out.print(" " + temp.get(j).data);
//            System.out.println();
//        }


        int height[] = new int[n];
        String root = scanner.nextInt() + "";
        for (int i = 0; i < tree.size(); i++) {
            Node temp = tree.get(i);
            height[i] = 0;
            if (temp.data == root) {
                List children = temp.getChildren();
                for (int j = 0; j < children.size(); j++) {

                }
            }
        }
    }
}
