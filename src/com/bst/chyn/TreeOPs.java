package com.bst.chyn;

import com.chyn.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    private class NodeLR {
        int leftWeight;
        int rightWeight;

        NodeLR(int l, int r) {
            leftWeight = l;
            rightWeight = r;
        }
    }

    Node longPath(Node root) {
        Map<Node, NodeLR> map = new HashMap<Node, NodeLR>();
        if (root != null) {
            traverse(root, map);
        }
        Node toReturn = root;
        NodeLR temp = new NodeLR(0, 0);
        int max = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry tuple = (Map.Entry) it.next();
            temp = (NodeLR) tuple.getValue();
            if (max < (temp.leftWeight + temp.rightWeight)) {
                toReturn = (Node) tuple.getKey();
                max = temp.leftWeight + temp.rightWeight;
            }
        }
        trace(root, map);
        return toReturn;
    }

    //this function expects a complete left right weights map.
    void trace(Node root, Map map) {
        NodeLR temp = new NodeLR(0, 0);
        temp = (NodeLR) map.get(root);
        Node left = null, right = null;
        if (root.left != null) {
            left = root.left;
            while (left.left != null || left.right != null) {
                temp = (NodeLR) map.get(left);
                if (temp.leftWeight > temp.rightWeight) left = left.left;
                else left = left.right;
            }
        }
        if (root.right != null) {
            right = root.right;
            while (right.left != null || right.right != null) {
                temp = (NodeLR) map.get(right);
                if (temp.leftWeight > temp.rightWeight) right = right.left;
                else right = right.right;
            }
        }

        //found a left and right node.
        System.out.println("The left most node on Longest path is : " + left.data);
        System.out.println("The right most node on Longest path is : " + right.data);

    }

    void traverse(Node root, Map map) {
        int leftDepth = 0, rightDepth = 0;
        if (root.left != null) {
            leftDepth = depth(root.left);
            traverse(root.left, map);
        }
        if (root.right != null) {
            rightDepth = depth(root.right);
            traverse(root.right, map);
        }
        NodeLR nodeLR = new NodeLR(leftDepth, rightDepth);
        System.out.println("Node with root : " + root.data + " 's left depth is : " + leftDepth + " and right depth is : " + rightDepth);
        map.put(root, nodeLR);
    }


}
