package com.bst.chyn;

import com.chyn.*;

/**
 * Created by v-vetula on 5/5/2016.
 */
public class TreeOPs {

    //function to return the depth of a node on a BT.
    int depth(Node root) {
        int leftDepth = 0, rightDepth = 0;
        if (root.left != null) leftDepth = depth(root.left);
        if (root.right != null) rightDepth = depth(root.right);
        if (leftDepth > rightDepth) return leftDepth + 1;
        return rightDepth + 1;
    }

    //function to return least common ancestor on a BST.
    Node lca(Node root, int v1, int v2) {
        if (root == null) return root;
        if (root.data > v1 && root.data > v2) return lca(root.left, v1, v2);
        if (root.data < v1 && root.data < v2) return lca(root.right, v1, v2);
        return root;
    }
}
