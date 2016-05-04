package com.chyn;

/**
 * Created by v-vetula on 4/22/2016.
 */
public class mergeLinked {

    Node Insert2(Node head,int data) {
        Node temp = head;
        if(head == null) {
            head.data = data;
            head.next = null;
            return head;
        }
        while(temp.next != null) temp = temp.next;
        Node new_node = new Node();
        new_node.data = data;
        temp.next = new_node;
        new_node.next = null;
        return head;

    }

    Node MergeLists(Node headA, Node headB) {
        Node temp = new Node();
        temp = null;
        if(headA == null) return headB;
        else{
            if(headB == null) return headA;
            else{
                while(headA != null || headB != null){
                    if(headA.data > headB.data ){
                        Insert2(temp, headB.data);
                        headB = headB.next;
                    }
                    else{
                        Insert2(temp, headA.data);
                        headA = headA.next;
                    }
                }
                if(headA == null){
                    while(headB != null){
                        Insert2(temp, headB.data);
                        headB = headB.next;
                    }
                }
                else{
                    while(headA != null){
                        Insert2(temp, headA.data);
                        headA = headA.next;
                    }
                }
            }
        }
        return temp;
    }


}
