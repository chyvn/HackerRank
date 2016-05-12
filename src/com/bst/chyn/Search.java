package com.bst.chyn;

import java.util.Stack;

/**
 * Created by v-vetula on 5/12/2016.
 */
public class Search {
    boolean dfs(Node root, int key) {
        boolean found = false;
        if (root != null) {
            if (root.data == key) found = true;

            Stack<Node> stack = new Stack<>();
            stack.push(root);
            System.out.println("Call stack is :");
            while (!found && stack.size() > 0) {
                Node temp = stack.pop();
                System.out.println(temp.data);
                if (temp.data == key) found = true;
                else {
                    if (temp.left != null) stack.push(temp.left);
                    if (temp.right != null) stack.push(temp.right);
                }
            }

        }
        return found;
    }

    boolean bfs(Node root, int key) {
        boolean found = false;
        if (root != null) {
            if (root.data == key) found = true;

            Stack<Node> stack = new Stack<>();
            stack.push(root);
            System.out.println("Call stack is :");
            while (!found && stack.size() > 0) {
                Node temp = stack.get(0);
                stack.removeElementAt(0);
                System.out.println(temp.data);
                if (temp.data == key) found = true;
                else {
                    if (temp.left != null) stack.push(temp.left);
                    if (temp.right != null) stack.push(temp.right);
                }
            }

        }
        return found;
    }

}
