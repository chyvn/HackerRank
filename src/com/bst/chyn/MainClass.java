package com.bst.chyn;

/**
 * Created by v-vetula on 5/4/2016.
 */
public class MainClass {
    public static void main(String[] args) {
        Node root = new Node();

        /*
        * use insert function from Node class to add any new elements
        * use any of the traversals. */

        root = root.insert(root, 9);
        root = root.insert(root, 2);
        root = root.insert(root, 3);
        root = root.insert(root, 10);

        root.Postorder(root);
    }
}
