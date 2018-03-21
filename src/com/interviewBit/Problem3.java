package com.interviewBit;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}


class Tree {
    TreeNode root;

    void Tree() {
        root = null;
    }

    void insert(int val) {
        if (root == null) root = new TreeNode(val);
        else {
            TreeNode temp = root;
            while (true) {
                if (temp.val > val) {
                    if (temp.left == null) {
                        temp.left = new TreeNode(val);
                        return;
                    }
                    else temp = temp.left;
                }
                else {
                    if (temp.right == null) {
                        temp.right = new TreeNode(val);
                        return;
                    }
                    else temp = temp.right;

                }
            }

        }
    }

}

public class Problem3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tree tree = new Tree();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        tree.insert(array[0]);

        TreeNode root = tree.root;
        ArrayList<TreeNode> treeList = new ArrayList<>();
        treeList.add(root);
        int pivot = 0;
        for (int i = 1; i < n; i += 2) {
            if (array[i] != -1) treeList.add(treeList.get(pivot).left = new TreeNode(array[i]));
            if (array[i + 1] != -1) treeList.add(treeList.get(pivot).right = new TreeNode(array[i + 1]));
            ++pivot;
        }

        inorder(tree.root);
        System.out.println();

        System.out.print(maxDepth(tree.root));

        ArrayList<ArrayList<Integer>> A = zigZagLOBT(tree.root);
        for (ArrayList<Integer> P : A) {
            for (Integer i : P) System.out.print(i + " ");
            System.out.println();
        }

//        System.out.print(kthsmallest(tree.root, scanner.nextInt()));

//        System.out.println(isSymmetric(tree.root));
/*
        tree.root = invert(tree.root);
        inorder(tree.root);*/


    }

    public static ArrayList<ArrayList<Integer>> zigZagLOBT(TreeNode A) {

        if (A == null) return null;
        else {
            ArrayList<TreeNode> nodeList = new ArrayList<>();
            ArrayList<Integer> nodeLevel = new ArrayList<>();

            nodeList.add(A);
            nodeLevel.add(0);

            int opIndex = 0;
            while (opIndex < nodeList.size()) {
                TreeNode me = nodeList.get(opIndex);
                int myIndex = nodeLevel.get(opIndex);

                if (me.left != null) {
                    nodeList.add(me.left);
                    nodeLevel.add(myIndex + 1);
                }
                if (me.right != null) {
                    nodeList.add(me.right);
                    nodeLevel.add(myIndex + 1);
                }
                opIndex++;
            }

            ArrayList<ArrayList<Integer>> toRet = new ArrayList<>();
            for (int i = 0; i < nodeLevel.size(); i++) {
                int thisLevel = nodeLevel.get(i);
                if (toRet.size() <= thisLevel) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(nodeList.get(i).val);
                    toRet.add(tempList);
                }
                else {
                    ArrayList<Integer> tempList = toRet.get(thisLevel);
                    if (thisLevel % 2 != 0) tempList.add(0, nodeList.get(i).val);
                    else tempList.add(nodeList.get(i).val);

                }
            }
            return toRet;

        }
    }

    public static int maxDepth(TreeNode A) {
        if (A == null) return 0;

        int leftDepth = 0;
        int rghtDepth = 0;
        if (A.left != null) leftDepth = maxDepth(A.left);
        if (A.right != null) rghtDepth = maxDepth(A.right);

        if (leftDepth == 0 && rghtDepth == 0) return 1;
        if (leftDepth != 0 && rghtDepth != 0) return (leftDepth < rghtDepth) ? (leftDepth + 1) : (rghtDepth + 1);
        if (leftDepth != 0 && rghtDepth == 0) return leftDepth + 1;
        if (rghtDepth != 0 && leftDepth == 0) return rghtDepth + 1;

        else return 1;

    }

    public static TreeNode invert(TreeNode A) {
        if (A == null) return A;
        else {
            ArrayList<TreeNode> AList = new ArrayList<>();
            ArrayList<TreeNode> BList = new ArrayList<>();

            AList.add(A);
            BList.add(new TreeNode(A.val));

            int opIndex = 0;
            while (opIndex < AList.size()) {
                TreeNode ANode = AList.get(opIndex);
                TreeNode BNode = BList.get(opIndex);

                if (ANode.left != null) {
                    BNode.right = new TreeNode(ANode.left.val);
                    AList.add(ANode.left);
                    BList.add(BNode.right);
                }

                if (ANode.right != null) {
                    BNode.left = new TreeNode(ANode.right.val);
                    AList.add(ANode.right);
                    BList.add(BNode.left);
                }

                ++opIndex;
            }

            return BList.get(0);
        }
    }

    public static int isSymmetric(TreeNode A) {

        if (A == null) return 1;

        ArrayList<TreeNode> leftList = new ArrayList<>();
        ArrayList<TreeNode> rightList = new ArrayList<>();

        if (A.left != null && A.right != null) {
            leftList.add(A.left);
            rightList.add(A.right);
        }
        else return 0;

        int opIndex = 0;
        while (opIndex < leftList.size()) {
            TreeNode leftOpNode = leftList.get(opIndex);
            TreeNode rightOpNode = rightList.get(opIndex);

            if (leftOpNode.val == rightOpNode.val) {
                if (leftOpNode.left != null && rightOpNode.right != null) {
                    leftList.add(leftOpNode.left);
                    rightList.add(rightOpNode.right);
                }
                else if (leftOpNode.left == null && rightOpNode.right == null) {
                }
                else return 0;

                if (leftOpNode.right != null && rightOpNode.left != null) {
                    leftList.add(leftOpNode.right);
                    rightList.add(rightOpNode.left);
                }
                else if (leftOpNode.right == null && rightOpNode.left == null) {
                }
                else return 0;
            }
            else return 0;

            ++opIndex;
        }
        return 1;
    }

    public static int isIdentical(TreeNode A, TreeNode B) {

        if (A == null && B == null) return 1;
        else if (A != null && B != null) {
            ArrayList<TreeNode> treeANodeList = new ArrayList<>();
            ArrayList<TreeNode> treeBNodeList = new ArrayList<>();

            treeANodeList.add(A);
            treeBNodeList.add(B);

            int opIndex = 0;
            while (opIndex < treeANodeList.size()) {
                TreeNode ANode = treeANodeList.get(opIndex);
                TreeNode BNode = treeBNodeList.get(opIndex);

                if (ANode.val == BNode.val) {
                    if (ANode.left != null && BNode.left != null) {
                        treeANodeList.add(ANode.left);
                        treeBNodeList.add(BNode.left);
                    }
                    else if (ANode.left == null && BNode.left == null) {
                    }
                    else return 0;

                    if (ANode.right != null && BNode.right != null) {
                        treeANodeList.add(ANode.right);
                        treeBNodeList.add(BNode.right);
                    }
                    else if (ANode.right == null && BNode.right == null) {

                    }
                    else return 0;
                }
                else return 0;

                ++opIndex;
            }

            return 1;
        }
        else return 0;
    }

    public static int leastCommonAncestor(TreeNode A, int val1, int val2) {
        ArrayList<Integer> traceRouteVal1 = new ArrayList<>();
        ArrayList<Integer> traceRouteVal2 = new ArrayList<>();

        traceRouteVal1 = getRoute(A, val1);
        traceRouteVal2 = getRoute(A, val2);
        return 0;
    }

    public static ArrayList<Integer> getRoute(TreeNode A, int val1) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(A);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.peek();
            if (temp.val == val1) {
                //convert this to Array list and return
                return null;
            }
            else {
                if (temp.left != null) stack.add(temp.left);
                else {

                }
            }
        }
        return null;
    }

    public static int kthsmallest(TreeNode A, int B) {
        int retVal = -1;
        if (A.left != null) retVal = kthsmallest(A.left, B);
        if (retVal != -1) return retVal;
        B--;
        if (B == 0) return A.val;
        if (A.right != null) retVal = kthsmallest(A.right, B);
        return retVal;
    }

    public static void inorder(TreeNode root) {
        if (root.left != null) inorder(root.left);
        System.out.print(root.val + " ");
        if (root.right != null) inorder(root.right);
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {

        int opIndex = 0;
        ArrayList<TreeNode> nodeArrayList = new ArrayList<>();
        nodeArrayList.add(A);
        ArrayList<Integer> leftArray = new ArrayList<>();
        leftArray.add(0);
        ArrayList<Integer> rightArray = new ArrayList<>();
        rightArray.add(0);

        HashMap<Integer, ArrayList<Integer>> hash = new HashMap<>();


        while (nodeArrayList.size() != opIndex) {

            TreeNode temp = nodeArrayList.get(opIndex);
            int leftIndex = leftArray.get(opIndex);
            int rightIndex = rightArray.get(opIndex);

            if (temp.left != null) {
                nodeArrayList.add(temp.left);
                leftArray.add(leftIndex + 1);
                rightArray.add(rightIndex);
            }

            if (temp.right != null) {
                nodeArrayList.add(temp.right);
                leftArray.add(leftIndex);
                rightArray.add(rightIndex + 1);
            }

            if (hash.get(rightIndex - leftIndex) == null) {
                ArrayList<Integer> tempArryList = new ArrayList<>();
                tempArryList.add(temp.val);
                hash.put(rightIndex - leftIndex, tempArryList);
            }
            else {
                ArrayList<Integer> tempArryList = hash.get(rightIndex - leftIndex);
                tempArryList.add(temp.val);
                hash.put(rightIndex - leftIndex, tempArryList);
            }
            ++opIndex;
        }

        ArrayList<ArrayList<Integer>> toRet = new ArrayList<>();

        // need to convert the hash map to array list.
        Set<Integer> keySet = hash.keySet();
        int min = 0;
        for (Integer i : keySet) if (i < min) min = i;

        for (int i = min; i < hash.size(); i++) if (hash.get(i) != null) toRet.add(hash.get(i));

        return toRet;

    }

    public static HashMap<Integer, ArrayList<Integer>> vot(TreeNode node, HashMap<Integer, ArrayList<Integer>> A, int l, int r) {

        if (node.left != null) vot(node.left, A, (l + 1), r);

        int myVal = r - l;
        ArrayList<Integer> temp = A.get(myVal);
        if (temp == null) temp = new ArrayList<>();
        temp.add(node.val);
        A.put(myVal, temp);

        if (node.right != null) vot(node.right, A, l, (r + 1));

        return A;
    }

    public static int isBalanced(TreeNode A) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (A.left != null) leftHeight = isBal(A.left);
        if (A.right != null) rightHeight = isBal(A.right);

        if (leftHeight == -1 || rightHeight == -1) return 0;

        if (leftHeight > rightHeight) {
            if (leftHeight - rightHeight <= 1) return 1;
            else return 0;
        }
        else {
            if (rightHeight - leftHeight <= 1) return 1;
            else return 0;
        }
    }

    public static int isBal(TreeNode A) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (A.left != null) {
            leftHeight = isBal(A.left);
            if (leftHeight == -1) return -1;
        }
        if (A.right != null) {
            rightHeight = isBal(A.right);
            if (rightHeight == -1) return -1;
        }

        int diff = 0;
        if (leftHeight > rightHeight) diff = leftHeight - rightHeight;
        else diff = rightHeight - leftHeight;
        if (diff > 1) return -1;
        else {
            if (leftHeight > rightHeight) return leftHeight + 1;
            else return rightHeight + 1;
        }

    }
}
