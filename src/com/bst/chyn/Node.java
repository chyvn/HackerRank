package com.bst.chyn;

/**
 * Created by v-vetula on 5/4/2016.
 */
public class Node {
    int data;
    Node left;
    Node right;


    public Node insert(Node root, int data){
        if(root == null){
            root = new Node();
            root.data = data;
            root.left = null;
            root.right = null;
            return root;
        }

        else{
            Node temp = root;
            if(data > temp.data){
                if(temp.right != null) insert(temp.right, data);
                else{
                    Node newNode = new Node();
                    newNode.data =data;
                    temp.right = newNode;
                    newNode.left = null;
                    newNode.right = null;
                }
            }
            else{
                if(temp.left != null) insert(temp.left, data);
                else{
                    Node newNode = new Node();
                    newNode.data =data;
                    temp.left = newNode;
                    newNode.left = null;
                    newNode.right = null;
                }
            }
        }
        return root;
    }

    public void Inorder(Node root){
        if(root != null){
            if(root.left != null) Inorder(root.left);
            System.out.print(root.data + " ");
            if(root.right != null) Inorder(root.right);
        }
    }

    public void Preorder(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            if(root.left != null) Preorder(root.left);
            if(root.right != null) Preorder(root.right);
        }
    }

    public void Postorder(Node root){
        if(root != null){
            if(root.left != null) Postorder(root.left);
            if(root.right != null) Postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
