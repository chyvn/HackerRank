package com.chyn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by v-vetula on 4/22/2016.
 */
public class LevelOrder {
    void LevelOrder(Node root){
        Queue<Node> queue= new LinkedList<Node>();
        if(root != null){
            queue.add(root);
            while(queue.size() > 0) {
                Node temp = new Node();
                temp = queue.remove();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                System.out.print(temp.data + " ");
            }
        }
    }
}
