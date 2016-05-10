package com.heap.chyn;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
                if(newNode.parent == null){
                    //we've reached the top of heap, so we are replacing the head
                    root = newNode;
                }
            }
        }
    }

    int getMax() {
        if (root == null) return -1;
        return root.data;
    }

    void remove(int data) {
        Node target = getNode(data, root);

        //get the last node's data, and place it in the target.
        Node lastNode = parentQueue.get(parentQueue.size() - 1);

        //remove the last node form it's parent
        if (lastNode.parent.left == lastNode) lastNode.parent.left = null;
        else lastNode.parent.right = null;
        target.data = lastNode.data;

        //operte on the target node, to place it in the appropriate level.
        settleInPlace(target);
    }

    void settleInPlace(Node target) {
        if (target.left != null) {
            if (target.left.data > target.data) {
                //swap them and settle the target left's data
                int temp = target.data;
                target.data = target.left.data;
                target.left.data = temp;
                settleInPlace(target.left);
            }
        }
    }

    Node getNode(int data, Node root) {
        if (root.data == data) return root;
        if (root.left != null) return getNode(data, root.left);
        if (root.right != null) return getNode(data, root.right);
        return null;
    }
}
