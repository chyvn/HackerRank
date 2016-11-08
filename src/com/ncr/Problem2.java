package com.ncr;

import java.util.Scanner;

/**
 * Created by chyvn on 07-11-2016.
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        char array[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            String temp[] = scanner.next().split("");
            for (int j = 0; j < m; j++) {
                array[i][j] = temp[j].charAt(0);
            }
        }

        int direction = 1;
        boolean condition = true;
        int i = n - 1;
        int j = 0;
        int count = 0;
        int toggle = 1;
        int iteration = 0;
        int a, b;
        if (n % 2 == 0) a = n / 2;
        else a = n / 2 + 1;
        if (m % 2 == 0) b = m / 2;
        else b = m / 2 + 1;

        while (condition) {
            System.out.print(array[i][j] + " ");

            if (array[i][j] != '#' && toggle == 1) toggle = 0;
            if (array[i][j] == '#' && toggle == 0) {
                toggle = 1;
                ++count;
            }

            if (direction == 1 && i > iteration) --i;
            else if (i == iteration) direction = 2;
            if (direction == 2 && j < m - 1 - iteration) ++j;
            else if (j == m - 1 - iteration) direction = 3;
            if (direction == 3 && i < n - 1 - iteration) ++i;
            else if (i == n - 1 - iteration) direction = 4;
            if (direction == 4 && j > iteration) --j;
            else if (j == iteration) {
                direction = 1;
                ++iteration;
            }

            if (i == a && j == b) condition = false;
        }

        System.out.print(count);
    }
}
