package com.bst.chyn;

import com.chyn.*;

/**
 * Created by v-vetula on 5/5/2016.
 */
public class TreeOPs {

    int depth(Node root){
        int leftDepth = 0, rightDepth = 0;
        if(root.left != null) leftDepth = depth(root.left);
        if(root.right != null) rightDepth = depth(root.right);
        if (leftDepth > rightDepth) return leftDepth + 1;
        return rightDepth + 1;
    }
}
