package com.chyn;

/**
 * Created by v-vetula on 4/26/2016.
 */
public class elementAtLocation extends Node {

    /*
  Insert Node at the end of a linked list
  head pointer input could be NULL as well for empty list
  Node is defined as
  class Node {
     int data;
     Node next;
     Node prev;
  }

*/

    Node SortedInsert(Node head, int data) {
        if (head == null) {
            head = new Node();
            head.data = data;
            head.next = null;
            head.prev = null;
            return head;
        } else {
            Node temp = head;
            while (head.data < data || head.next != null) head = head.next;
            if (head.next != null) {
                Node newNode = new Node();
                newNode.data = data;
                newNode.prev = head;
                newNode.next = head.next;
                head.next = newNode;
                head.next.prev = newNode;
                return temp;
            } else {
                Node newNode = new Node();
                newNode.data = data;
                newNode.next = head.next;
                head.next = newNode;
                newNode.prev = head;
                return temp;
            }
        }

    }

}
