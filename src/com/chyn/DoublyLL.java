package com.chyn;

/**
 * Created by chyn on 15-May-16.
 */
public class DoublyLL<T> {

    Node root;
    Node end;
    int size;

    DoublyLL() {
        root = null;
        end = null;
        size = 0;
    }

    private class Node<T> {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
            next = null;
            prev = null;
        }
    }

    Node insert(T data) {
        if (root == null) {
            root = new Node(data);
            size++;
            end = root;
            root.next = end;
            root.prev = end;
            end.next = root;
            end.prev = root;
            return root;
        } else {
            Node newNode = new Node(data);
            ++size;
            newNode.next = end.next;
            newNode.prev = end;
            end = newNode;
            root.prev = end;
            return root;
        }
    }

    boolean isEmpty() {
        return root == null;
    }

    int getSize() {
        return size;
    }

    void print() {
        Node<T> temp = root;
        if (temp == null) {
            System.out.println("it's an empty list");
        }
        for (int i = 0; i < size; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("");
    }

    Node delete(T data) {
        if (root == null) return root;
        if (root.data.equals(data)) {
            //remove root.
            root.prev.next = root.next;
            root.next.prev = root.prev;
            root = root.next;
        } else {
            Node<T> temp = root;
            for (int i = 0; i < size; i++) {
                if (temp == end || temp.data.equals(data)) break;
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            --size;
            if (temp == end) {
                end = temp.prev;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        DoublyLL<Integer> dll = new DoublyLL<>();

        dll.insert(3);
        dll.insert(4);
        dll.insert(9);
        dll.insert(5);
        dll.insert(7);
        dll.insert(2);
        dll.insert(1);
        dll.print();
    }

}
