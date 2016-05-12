package com.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by v-vetula on 5/12/2016.
 */
public class Node {
    char data;
    int noChild;
    Map<Integer, Node> childList;

    Node(char data) {
        this.data = data;
        noChild = 0;
        childList = new HashMap<>();
    }

    boolean put(char data) {
        this.noChild++;
        Node childNode = new Node(data);
        this.childList.put(this.noChild, childNode);
        return true;
    }

    boolean searchDFS(char data) {
        boolean found = false;

        if (this.data == data) found = true;
        Stack<Node> stack = new Stack<>();
        stack.push(this);
        Node temp = this;
        while (!found && !stack.empty()) {
            temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.data == data) found = true;
            else {
                int iterate = temp.noChild;
                while (iterate > 0) {
                    stack.push(temp.childList.get(iterate));
                    --iterate;
                }
            }
        }

        return found;
    }

    boolean hasCycle() {
        //if a node already visited is seen then there is a cycle.
        boolean isCycle = false;

        //should be able to find self loops as well.
        Node temp = this;
        Stack<Node> stack = new Stack<>();
        Stack<String> isSeen = new Stack<>();
        isSeen.push(this.data + "");
        stack.push(this);
        boolean isFirst = true;
        while (!isCycle && !stack.empty()) {
            temp = stack.pop();
            if (isSeen.contains(temp.data + "") && !isFirst) isCycle = true;
            else {
                int iterate = temp.noChild;
                while (iterate > 0) {
                    stack.push(temp.childList.get(iterate));
                    --iterate;
                }
            }
            isFirst = false;

        }
        return isCycle;
    }

    boolean searchBFS(char data) {
        boolean found = false;

        if (this.data == data) found = true;
        Stack<Node> stack = new Stack<>();
        stack.push(this);
        Node temp = this;
        while (!found && !stack.empty()) {
            temp = stack.get(0);
            stack.remove(0);
            System.out.print(temp.data + " ");
            if (temp.data == data) found = true;
            else {
                int iterate = temp.noChild;
                while (iterate > 0) {
                    stack.push(temp.childList.get(iterate));
                    --iterate;
                }
            }
        }

        return found;
    }

    public static void main(String[] args) {
        Node root = new Node('a');
        root.put('b');
        root.put('c');
        root.put('d');
        root.put('e');
        root.put('f');
        Node temp = root.childList.get(1);
        temp.put('g');
        temp.put('h');
        temp.put('i');
        temp.put('j');
        temp.put('a');
        temp = root.childList.get(2);
        temp.put('k');
        temp = root.childList.get(3);
        temp.put('l');
        temp.put('m');
        temp.put('n');
        temp = root.childList.get(4);
        temp.put('o');
        temp = root.childList.get(5);
        temp.put('p');
        /*System.out.println(temp.searchBFS('g'));
        System.out.println(root.searchBFS('g'));
        System.out.println(temp.searchBFS('p'));
        System.out.println(root.searchDFS('p'));
        System.out.println(temp.searchDFS('f'));
        System.out.println(root.searchDFS('x'));*/

        System.out.println(root.hasCycle());

    }
}
