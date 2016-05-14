package com.bst.chyn;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by v-vetula on 5/11/2016.
 */
public class DoorsWindows {

    public class MyNode {
        MyNode top;
        MyNode bottom;
        MyNode left;
        MyNode right;
        int key;
        int data;

        MyNode(int data, int key) {
            this.left = null;
            this.right = null;
            this.top = null;
            this.bottom = null;
            this.data = data;
            this.key = key;
        }
    }

    Map<Integer, MyNode> nodeMap = new HashMap<Integer, MyNode>();

    //this class generates the BST from given matrix.
    MyNode generateTree(int n, int[][] array) {


        //creating all nodes and putting in values.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i * n + j;
                MyNode temp = new MyNode(array[i][j], key);
                nodeMap.put(key, temp);
            }
        }

        //connecting the nodes.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                MyNode temp;
                int key = i * n + j;
                temp = nodeMap.get(key);
                if (i != 0) temp.top = nodeMap.get(key - n);
                if (j != 0) temp.left = nodeMap.get(key - 1);
                if (i != n - 1) temp.bottom = nodeMap.get(key + n);
                if (j != n - 1) temp.right = nodeMap.get(key + 1);
            }
        }

        return (nodeMap.get(0));
    }


    MyNode getNearestDoor(int x, int y, int n) {
        int key = x * n + y;
        boolean[] visited = new boolean[n * n];
        for (int i = 0; i < n * n; i++) {
            visited[i] = false;
        }
        if (nodeMap.get(key).data == 3) {
            return nodeMap.get(key);
        } else {
            Stack<MyNode> keyStack = new Stack<>();
            keyStack.push(nodeMap.get(key));
            visited[key] = true;
            boolean found = false;
            while (!found && keyStack.size() > 0) {
                MyNode temp = keyStack.remove(0);
                if (temp.data == 3) return temp;
                else {
                    visited[temp.key] = true;
                    if (temp.bottom != null && temp.data != 2 && !visited[temp.bottom.key])
                        keyStack.push(temp.bottom);

                    if (temp.top != null && temp.data != 2 && !visited[temp.top.key])
                        keyStack.push(temp.top);

                    if (temp.right != null && temp.data != 2 && !visited[temp.right.key])
                        keyStack.push(temp.right);

                    if (temp.left != null && temp.data != 2 && !visited[temp.left.key])
                        keyStack.push(temp.left);

                }
            }
        }
        return null;

    }


    void print(MyNode root, int dir) {
        if (dir == 1) {
            System.out.print(root.data + " " + root.key + "->");
            if (root.right == null) {
                if (root.bottom != null) {
                    System.out.println("");
                    print(root.bottom, 0);
                }
            } else print(root.right, dir);
        } else {
            System.out.print("<-" + root.data + " " + root.key);
            if (root.left == null) {
                if (root.bottom != null) {
                    System.out.println("");
                    print(root.bottom, 1);
                }
            } else print(root.left, dir);
        }
    }


}
