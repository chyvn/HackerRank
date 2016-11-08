package com.contest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by chyvn on 05-11-2016.
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int array[] = new int[n];

        //reading edge information.
        int graph[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            array[i] = 0;
            for (int j = 0; j < n; j++) graph[i][j] = 0;
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;

            graph[a][b]++;
        }

        //reading queries.
        while (q > 0) {
            --q;
            int option = scanner.nextInt();
            if (option == 1) {
                int u = scanner.nextInt() - 1;
                int x = scanner.nextInt();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(u);
                while (! queue.isEmpty()) {
                    int index = queue.remove();
                    array[index] = x;
                    for (int i = 0; i < n; i++) {
                        if (graph[index][i] > 0) queue.add(i);
                    }
                }
            } else if (option == 2) {
                int u = scanner.nextInt() - 1;
                int x = scanner.nextInt();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(u);
                while (! queue.isEmpty()) {
                    int index = queue.remove();
                    if (array[index] > x) array[index] = x;
                    for (int i = 0; i < n; i++) {
                        if (graph[index][i] > 0) queue.add(i);
                    }
                }
            } else {
                int u = scanner.nextInt();
                System.out.println(array[u - 1]);
            }
        }
    }
}
