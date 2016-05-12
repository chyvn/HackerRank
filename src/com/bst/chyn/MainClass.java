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
        Node root = new Node();

        int i = 10000;
        root = root.insert(null, 5000);
        while(i>0){
            --i;
            Random random = new Random();
            root.insert(root, (random.nextInt(10000) + 1));
        }


        root.Inorder();

        Search search = new Search();
        System.out.print("bfs" + search.bfs(root, 7772));
        System.out.print("dfs" + search.dfs(root, 7772));

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
/*
        //code for windows doors problem
        DoorsWindows problem = new DoorsWindows();
        int n = 6;
        int[][] array = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 8, 7, 6},
                {0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0}
        };
        DoorsWindows.MyNode root = problem.generateTree(n, array);
        problem.print(root, 1);
        int result = problem.getNearestDoor(3, 2, 6);
        System.out.println("iterative search found the distance t be : " + result);*/
    }
}
