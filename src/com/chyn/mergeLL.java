package com.chyn;

/**
 * Created by chyn on 24-May-16.
 */
public class mergeLL {

    static Node insAvi(Node root, int data) {
        Node temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        temp.next = newNode;

        return root;
    }

    static Node MergeLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method

        if (headA == null) return headB;
        if (headB == null) return headA;

        Node newRoot = null;

        while (headA != null && headB != null) {
            if (headA.data > headB.data) {
                if (newRoot == null) {
                    newRoot = new Node();
                    newRoot.data = headB.data;
                    headB = headB.next;
                } else {
                    newRoot = insAvi(newRoot, headB.data);
                    headB = headB.next;
                }
            } else {
                if (newRoot == null) {
                    newRoot = new Node();
                    newRoot.data = headA.data;
                    headA = headA.next;
                } else {
                    newRoot = insAvi(newRoot, headA.data);
                    headA = headA.next;
                }
            }
        }

        if (headA == null && headB != null) {
            while (headB != null) {
                newRoot = insAvi(newRoot, headB.data);
                headB = headB.next;
            }
        }

        if (headB == null && headA != null) {
            while (headA != null) {
                newRoot = insAvi(newRoot, headA.data);
                headA = headA.next;
            }
        }


        return newRoot;
    }

    public static void main(String[] args) {
        Node LL1 = new Node();

        LL1.data = 5;
        LL1.next = new Node();
        LL1.next.data = 6;

        LL1 = insAvi(LL1, 8);
        LL1 = insAvi(LL1, 10);


        Node LL2 = new Node();
        LL2.data = 7;
        LL2.next = new Node();
        LL2.next.data = 9;

        LL2 = insAvi(LL2, 81);
        LL2 = insAvi(LL2, 88);

        LL1 = MergeLists(LL1, LL2);

        Node temp = new Node();

    }

}
