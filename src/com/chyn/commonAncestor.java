package com.chyn;

import java.util.Stack;

/**
 * Created by chyn on 23-Apr-16.
 */
public class commonAncestor {
    Node lca(Node root, int v1, int v2){
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        stack1 = search(root, v1);
        stack2 = search(root, v2);
        //search for v1, build an ancestor stack
        //search for v2, build an ancestor stack
        //pop them until they match.
        return root;
    }

    Stack search(Node root, int key){
        Stack s = new Stack();
        if(root.data != key){
            if(root.left != null) search(root.left, key);
            System.out.print(root.data + " ");
            if(root.right != null) search(root.right, key);
        }
        return s;
    }
}
