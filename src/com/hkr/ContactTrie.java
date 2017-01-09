package com.hkr;

import java.util.List;
import java.util.Scanner;

/**
 * Created by chyvn on 16-12-2016.
 */
public class ContactTrie {

    static Node root;

    ContactTrie() {
        root = new Node('1');
    }

    static void addData(String data) {
        Node temp = root.getChild(data.charAt(0));
        int index = 1;
        Node parent = temp;
        while (temp != null && index < data.length()) {
            parent = temp;
            temp = temp.getChild(data.charAt(index));
            ++index;
        }
        if (index < data.length() - 1) {
            while (index < data.length()) {
                Node newNode = new Node(data.charAt(index));
                parent.children.add(newNode);
                parent = newNode;
                ++index;
            }
        }

    }

    static int search(String data) {
        Node temp = root.getChild(data.charAt(0));
        int index = 1;
        while (index < data.length()) {
            if (temp.isChild(data.charAt(index))) ++index;
            else return 0;
        }
        return temp.getChildSize();
    }

    public static class Node {
        char data;
        List<Node> children;

        Node(char data) {
            this.data = data;
        }

        boolean isChild(char a) {
            for (int i = 0; i < this.children.size(); i++) {
                if (this.children.get(i).data == a) return true;
            }
            return false;
        }

        Node getChild(char a) {
            for (int i = 0; i < this.children.size(); i++) {
                if (this.children.get(i).data == a) return this.children.get(i);
            }
            return null;
        }

        int getChildSize() {
            return this.children.size();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String key = scanner.next();
        if (key == "add") {
            String data = scanner.next();
            addData(data);
        } else {
            String data = scanner.next();
            // do the search operation.
            int names = search(data);
            System.out.println(names);
        }
    }


}
