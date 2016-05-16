package com.bst.chyn;

import java.util.Random;

/**
 * Created by v-vetula on 5/4/2016.
 */
public class MainClass {
    public static void main(String[] args) {

        /*
        * use insert function from Node class to add any new elements
        * use any of the traversals. */
    doors();

        //treeSearch();

        /*
        sumNodes sumNodes = new sumNodes();
        //sumNodes.sumNodeGenerate(root).Inorder();
        int[] levelsums = sumNodes.levelSums(root);
        for (int i = 0; i < levelsums.length && levelsums[i] != 0; i++)
            System.out.println("At level " + (i + 1) + " the sum is : " + levelsums[i]);
        System.out.println("");
        sumNodes.sumNodeGenerate2(root).Inorder();
        levelsums = sumNodes.levelSums(root);
        System.out.println("");
        for (int i = 0; i < levelsums.length && levelsums[i] != 0; i++)
            System.out.println("At level " + (i + 1) + " the sum is : " + levelsums[i]);
            */
/*
        TreeOPs treeOPs = new TreeOPs();
        System.out.println("longest path's LCA is " + treeOPs.longPath(root).data);

        //System.out.println("Depth of the tree is : " + treeOPs.depth(root));
        System.out.println("common ancestor of 1 and 6 is : " + treeOPs.lca(root, 1, 2).data);*/

        //code for windows doors problem

    }

    static void treeSearch(){
        Node root = new Node();

        int i = 10;
        root = root.insert(null, 5);
        while(i>0){
            --i;
            //Random random = new Random();
            root.insert(root, i);
        }


        root.Inorder();

        Search search = new Search();

        System.out.print("bfs" + search.bfs(root, 6));
        System.out.print("dfs" + search.dfs(root, 6));
    }


    private static void doors(){
        DoorsWindows problem = new DoorsWindows();
        int n = 6;
        int[][] array = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 2, 2, 0, 2, 0},
                {0, 2, 3, 0, 3, 0},
                {0, 2, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 3},
                {0, 0, 0, 0, 2, 0}
        };
        DoorsWindows.MyNode root = problem.generateTree(n, array);
        problem.print(root, 1);
        int node = problem.getNearestDoor(0, 0, 6);
        if (node == -1) {
            System.out.println("There is no escape :( .");
        }
        else{
            System.out.print("A node was found at a distance of " + node);
        }
    }

}
