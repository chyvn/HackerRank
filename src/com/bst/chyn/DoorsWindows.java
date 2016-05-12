package com.bst.chyn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by v-vetula on 5/11/2016.
 */
public class DoorsWindows {

    public class MyNode extends Node {
        Node top;
        Node bottom;

        MyNode(int data) {
            this.left = null;
            this.right = null;
            this.top = null;
            this.bottom = null;
            this.data = data;
        }
    }

    Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();

    //this class generates the BST from given matrix.
    MyNode generateTree(int n, int[][] array) {


        //creating all nodes and putting in values.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                MyNode temp = new MyNode(array[i][j]);
                int key = i * n + j;
                nodeMap.put(key, temp);
            }
        }

        //connecting the nodes.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                MyNode temp = new MyNode(0);
                int key = i * n + j;
                temp = (MyNode) nodeMap.get(key);
                if (i != 0) temp.top = nodeMap.get(key - n);
                if (j != 0) temp.left = nodeMap.get(key - 1);
                if (i != n - 1) temp.bottom = nodeMap.get(key + n);
                if (j != n - 1) temp.right = nodeMap.get(key + 1);
            }
        }

        return ((MyNode) nodeMap.get(0));
    }

    int getNearestDoor(int x, int y, int n) {
        int key = x * n + y;
        return iterativeSearch((MyNode) nodeMap.get(key), nodeMap, 0);

    }

    //need to test this and finalize.
    int iterativeSearch(MyNode node, Map map, int distance) {
        if (node.data == 3) return distance;
        if (node.right != null) return iterativeSearch((MyNode) node.right, map, ++distance);
        if (node.left != null) return iterativeSearch((MyNode) node.left, map, ++distance);
        if (node.top != null) return iterativeSearch((MyNode) node.top, map, ++distance);
        if (node.bottom != null) return iterativeSearch((MyNode) node.bottom, map, ++distance);
        return 0;
    }

    void print(MyNode root, int dir) {
        if (dir == 1) {
            System.out.print(root.data + "->");
            if (root.right == null) {
                if (root.bottom != null) {
                    System.out.println("");
                    print((MyNode) root.bottom, 0);
                }
            } else print((MyNode) root.right, dir);
        } else {
            System.out.print("<-" + root.data);
            if (root.left == null) {
                if (root.bottom != null) {
                    System.out.println("");
                    print((MyNode) root.bottom, 1);
                }
            } else print((MyNode) root.left, dir);
        }
    }


}
