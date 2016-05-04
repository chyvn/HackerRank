package com.chyn;

/**
 * Created by chyn on 04-May-16.
 */
public class nodeAtPosN {
    private Node function(Node head, int data, int position) {
        if (head == null) {
            head = new Node();
            head.data = data;
            head.next = null;
            return head;
        } else {
            //first find the length of linked list
            Node temp = head;
            while(position > 0 && temp.next != null){
                temp = temp.next;
                position--;
            }
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = temp.next;
            temp.next = newNode;
            }
            //find the exact position to insert the node in. (L - N)
        return head;
    }
}
