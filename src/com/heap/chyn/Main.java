package com.heap.chyn;

/**
 * Created by v-vetula on 5/9/2016.
 */
public class Main {
    public static void main(String[] args){
        Heap heap = new Heap();
        heap.insert(9);
        System.out.print(heap.getMax() + " ");
        heap.insert(20);
        System.out.print(heap.getMax() + " ");
        heap.insert(15);
        System.out.print(heap.getMax() + " ");
        heap.insert(89);
        System.out.print(heap.getMax() + " ");
        heap.insert(44);
        System.out.print(heap.getMax() + " ");
        heap.insert(15);
        System.out.print(heap.getMax() + " ");
        heap.insert(62);
        System.out.print(heap.getMax() + " ");
        heap.insert(21);
        System.out.print(heap.getMax() + " ");
        heap.insert(58);
        System.out.print(heap.getMax() + " ");
        heap.insert(29);
        System.out.print(heap.getMax() + " ");
        heap.insert(71);


    }
}
