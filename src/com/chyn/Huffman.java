package com.chyn;

/**
 * Created by chyn on 23-Apr-16.
 */
public class Huffman {
    void decode(String S, Node root){
        Node temp = root;
        if(root != null){
            int size = S.length();
            for(int i = 0; i<size; i++){
                if(S.charAt(size) == '0'){
                    if(temp.left == null){
                        System.out.print(temp.data);
                        temp = root;
                        --i;
                    }
                    else temp = temp.left;
                }
                else{
                    if(temp.right == null){
                        System.out.print(temp.data);
                        temp = root;
                        --i;
                    }
                    else temp = temp.right;
                }
            }
            System.out.print(temp.data);
        }
    }
}
