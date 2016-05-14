package com.heap.chyn;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v-vetula on 5/13/2016.
 */
public class FinalHeap {

    public class Node {
        int data;
        Node left;
        Node right;
        Node parent;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public class Heap {
        Node root;
        List<Node> parentQueue = new LinkedList<>();

        Heap() {
            root = null;
        }

        boolean insert(int data) {
            if (root == null) {
                root = new Node(data);
                //lastChild = root;
                parentQueue.add(root);
            } else {
                Node temp = parentQueue.get(0);
                Node newNode = new Node(data);
                if (temp.left == null) {
                    //we can inset the new node on the left.
                    temp.left = newNode;
                    parentQueue.add(newNode);
                } else {
                    temp.right = newNode;
                    parentQueue.add(newNode);
                    parentQueue.remove(0);
                }
            }
            return false;
        }

    }
}
