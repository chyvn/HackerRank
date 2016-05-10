package com.bst.chyn;

/**
 * Created by v-vetula on 5/4/2016.
 */
public class MainClass {
    public static void main(String[] args) {
        Node root = new Node();

        /*
        * use insert function from Node class to add any new elements
        * use any of the traversals. */

        root = root.insert(null, 8);
        root = root.insert(root, 4);
        root = root.insert(root, 9);
        root = root.insert(root, 1);
        root = root.insert(root, 2);
        root = root.insert(root, 3);
        root = root.insert(root, 6);
        root = root.insert(root, 5);
        root = root.insert(root, 10);


        root.Postorder(root);
        System.out.println("");

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

        TreeOPs treeOPs = new TreeOPs();
        System.out.println("longest path's LCA is " + treeOPs.longPath(root).data);

        //System.out.println("Depth of the tree is : " + treeOPs.depth(root));
        System.out.println("common ancestor of 1 and 6 is : " + treeOPs.lca(root, 1, 2).data);
    }
}
