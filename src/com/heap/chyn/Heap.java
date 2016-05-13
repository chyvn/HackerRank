package com.heap.chyn;

import com.hkr.math;

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
                if (newNode.parent == null) {
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

    int settleInPlace(Node target) {
        //have to check the minimum of the left and right.
        if (target.right == null) {
            if (target.left != null) {
                if (target.left.data > target.data) {
                    //swap them
                    int temp = target.data;
                    target.data = target.left.data;
                    target.left.data = temp;
                    //call the corresponding functions.
                    settleInPlace(target.left);
                } else return 0;
            } else return 0;
        } else {
            //find the max of left and right, and perform the same operation as above with that one.
            int max = Math.max(target.left.data, target.right.data);
            if (max > target.data) {
                //do the thing
                if (target.left.data == max) {
                    int temp = target.left.data;
                    target.left.data = target.data;
                    target.data = temp;
                    settleInPlace(target.left);
                } else {
                    int temp = target.right.data;
                    target.right.data = target.data;
                    target.data = temp;
                    settleInPlace(target.right);
                }
            } else return 0;
        }
        //if any of them are small, swap, and make a recursive call with the child who's value is changed.
        //else just break
        return 1;
    }

    Node getNode(int data, Node root) {
        if (root.data == data) return root;
        if (root.left != null) return getNode(data, root.left);
        if (root.right != null) return getNode(data, root.right);
        return null;
    }
}
