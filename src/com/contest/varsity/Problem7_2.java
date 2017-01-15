package com.contest.varsity;

import java.util.*;

/**
 * Created by chyvn on 13-01-2017.
 */
public class Problem7_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int tree[][] = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            int u, v;
            u = scanner.nextInt();
            v = scanner.nextInt();
            tree[u][v] = 1;
            tree[v][u] = 1;
        }

        int height[] = new int[n];
        int root = scanner.nextInt();
        height[root] = 1;
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int thisInt = queue.poll();
            for (int i = 0; i < n; i++) {
                if (tree[thisInt][i] == 1 && height[i] == 0) {
                    height[i] = height[thisInt] + 1;
                    queue.add(i);
                }
            }
        }

        int pathHeight[] = new int[n];
        int depth[] = new int[n];
        boolean visited[] = new boolean[n];
        for (int i = 0; i < n; i++) visited[i] = false;

        Stack<Integer> stack = new Stack<>();

        stack.add(root);
        visited[root] = true;
        while (!stack.empty()) {
            int i = stack.peek();
            boolean hasKids = false;
            for (int j = 0; j < n; j++) {
                if (tree[i][j] == 1 && !visited[j]) {
                    hasKids = true;
                    stack.add(j);
                    visited[j] = true;
                }
            }
            if (!hasKids) {
                stack.pop();
                int max = 0;
                int max2 = 0;
                for (int j = 0; j < n; j++) {
                    if (tree[i][j] == 1) {
                        if (depth[j] > max) {
                            max2 = max;
                            max = depth[j];
                        } else if (depth[j] > max2) max2 = depth[j];
                    }
                }
                depth[i] = max + 1;
                pathHeight[i] = max + max2;
            }
        }
        for (int i = 0; i < n; i++) System.out.print(height[i] + " ");
        System.out.println("\nThe depths : ");
        for (int i = 0; i < n; i++) System.out.print(depth[i] + " ");
        System.out.println("\nThe path possibles : ");
        int longestPath = 0;
        for (int i = 0; i < n; i++) {
            if (pathHeight[i] > longestPath) longestPath = pathHeight[i];
            System.out.print(pathHeight[i] + " ");
        }
        System.out.println("\nLongest path is of length : " + longestPath + " has nodes " + (longestPath + 1));

    }
}
