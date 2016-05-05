package com.bst.chyn;

/**
 * Created by v-vetula on 5/5/2016.
 * <p>
 * This class replaces all data of nodes with sum
 * of data from their children, leaves with no children
 * will contain 0.
 */
public class sumNodes {
    Node sumNodeGenerate(Node root) {
        int sum = 0;
        sum = alter(root, sum);
        return root;
    }

    Node sumNodeGenerate2(Node root) {
        int sum = 0;
        sum = alterForSum(root);
        return root;
    }

    int alter(Node root, int sum) {
        int leftSum = 0, rightSum = 0;
        if (root.left != null) leftSum += alter(root.left, sum);
        if (root.right != null) rightSum += alter(root.right, sum);
        int temp = root.data;
        root.data = leftSum + rightSum;
        return root.data + temp;
    }

    int alterForSum(Node root) {
        int leftSum = 0, rightSum = 0;
        if (root.left != null) leftSum += alterForSum(root.left);
        if (root.right != null) rightSum += alterForSum(root.right);
        root.data = leftSum + rightSum + root.data;
        return root.data;
    }

    int[] levelSums(Node root) {
        int[] sumsArray = new int[100];
        generateLevelSums(root, 0, sumsArray);
        return sumsArray;
    }

    void generateLevelSums(Node root, int index, int[] array) {
        if (root != null) {
            array[index] += root.data;
            if (root.left != null) generateLevelSums(root.left, (index + 1), array);
            if (root.right != null) generateLevelSums(root.right, (index + 1), array);
        }
    }

}
