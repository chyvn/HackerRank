package com.heap.chyn;

/**
 * Created by chyn on 08-May-16.
 */
public class Mian {
    public static void main(String[] args){
        Heap heap = new Heap();

        Node tmep = new Node(1);
        heap.insert(100);
        heap.insert(20);
        heap.insert(10);
        heap.insert(150);
        heap.insert(50);
        heap.insert(54);
        heap.insert(50);
        heap.insert(20);
        //heap.iterate(tmep);
        heap.insert(14);
        heap.insert(90);
        heap.insert(59);
        heap.insert(77);
        heap.insert(18);
        //heap.iterate(tmep);
    }
}
