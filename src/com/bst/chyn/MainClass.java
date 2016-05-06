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

        root = root.insert(null, 9);
        root = root.insert(root, 3);
        root = root.insert(root, 2);

        //root.Postorder(root);
        root.Inorder();
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
        System.out.println("Depth of the tree is : " + treeOPs.depth(root));
    }
}
