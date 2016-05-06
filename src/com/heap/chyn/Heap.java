package com.heap.chyn;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by v-vetula on 5/6/2016.
 */
public class Heap {

    Node root;
    Node lastParent = null;
    List<Node> parentQueue = new LinkedList();

    Heap() {
        root = null;
        lastParent = null;
    }

    void insert(int data) {
        if (root == null) {
            root = new Node(data);
            parentQueue.add(root);
        } else {
            Node temp = parentQueue.get(0);
            Node newNode = new Node(data);
            if (temp.left == null) {
                temp.left = newNode;
                newNode.parent = temp;
            } else if (temp.right == null) {
                temp.right = newNode;
                newNode.parent = temp;
                parentQueue.remove(0);
            }
            parentQueue.add(newNode);

            //making sure the largest element is always on top of the heap.
            //invert condition for smallest on top.
            while (newNode.parent.data < newNode.data) {
                int tempData = newNode.data;
                newNode.data = newNode.parent.data;
                newNode.parent.data = tempData;
                newNode = newNode.parent;
            }
        }
    }

    int getMax(){
        if(root == null) return -1;
        return root.data;
    }
}
