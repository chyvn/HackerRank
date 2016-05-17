package com.chyn;

/**
 * Created by chyn on 15-May-16.
 */
public class DoublyLL<T> {

    Node<T> root;
    Node<T> end;

    DoublyLL() {
        root = null;
        end = null;
    }

    private class Node<T> {
        T data;
        Node next;
        Node prev;

        public Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }

        public T get() {
            return this.data;
        }
    }

    Node insert(T data) {
        if (root == null) {
            root = new Node<>(data);
            end = root;
            root.next = end;
            root.prev = end;
            end.next = root;
            end.prev = root;
            return root;
        } else {
            Node newNode = new Node<>(data);
            newNode.next = end.next;
            newNode.prev = end;
            end = newNode;
            return root;
        }
    }
}
