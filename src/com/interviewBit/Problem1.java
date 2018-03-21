package com.interviewBit;


class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class LinkedList {
    public ListNode head;

    LinkedList() {
        head = null;
    }

    LinkedList(int x) {
        head = new ListNode(x);
    }

    void insert(int x) {
        if (head == null) head = new ListNode(x);
        else {
            ListNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = new ListNode(x);
        }
    }

    void traverse(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}


public class Problem1 {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(10);
        ll.insert(20);
        ll.insert(30);
        ll.insert(1);
        ll.insert(25);
        ll.insert(30);
        ll.insert(43);
        ll.insert(55);
        ll.insert(12);

        ListNode node = ll.head;
        ll.traverse(ll.head);
        node = reverse(ll.head);
        ll.traverse(node);
//        node = subtract(node);
    }

    public static ListNode reverse(ListNode node) {

        ListNode temp = node.next;
        node.next = null;
        ListNode temp2;
        if (temp != null) temp2 = temp.next;
        else return node;

        while (true) {
            node = temp;
            temp = temp2;
            if (temp2.next != null) temp2 = temp2.next;
            else return node;

            temp.next = node;

        }

    }

    public static ListNode subtract(ListNode A) {

        int length = getLen(A);

        return null;
    }

    public static int getLen(ListNode A) {
        int a = 0;
        while (A.next != null) {
            A = A.next;
            ++a;
        }
        return a++;
    }
}
