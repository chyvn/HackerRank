package com.heap.chyn;

/**
 * Created by v-vetula on 5/6/2016.
 */
public class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    Node(int data){
        this.data = data;
        this.left = this.right = this.parent = null;
    }
}
