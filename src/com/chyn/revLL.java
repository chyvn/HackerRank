package com.chyn;

/**
 * Created by v-vetula on 5/24/2016.
 */
public class revLL {

    Node rev(Node root, int k){

        //reversing part
        Node temp = root;
        Node previous = null;
        Node nextOp = null;
        while(temp != null){
            previous = nextOp;
            nextOp = temp;
            temp.next = previous;
            temp = nextOp.next;
        }

        //setting up the links.
        return root;
    }
}
