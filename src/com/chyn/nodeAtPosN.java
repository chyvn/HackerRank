package com.chyn;

/**
 * Created by chyn on 04-May-16.
 */
public class nodeAtPosN {
    private Node function(Node root, int data, int position) {
        if (root == null) {
            root = new Node();
            root.data = data;
            root.next = null;
            return root;
        } else {
            //first find the length of linked list
            int length = 0;
            Node temp = root;
            while (temp != null) {
                temp = temp.next;
                ++length;
            }
            //find the exact position to insert the node in. (L - N)
            if (length - position > 0){
                int index = length - position;
                temp = root;
                while(index > 0){
                    temp = temp.next;
                }
                Node newNode = new Node();
                newNode.data = data;
                newNode.next = temp.next;
                temp.next = newNode;
            }
            else{
                //not possible to insert it.
                Node newNode = new Node();
                newNode.data = data;
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        return root;
    }
}
