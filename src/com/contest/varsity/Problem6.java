package com.contest.varsity;

import java.util.Scanner;

/**
 * Created by chyvn on 04-01-2017.
 */
public class Problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            //System.out.print("Enter coefficient for " + i + "\n");
            a[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();
        long result = a[n];
        for (int i = n - 1; i >= 0; i--) {
            result = (result * x) + a[i];
        }
        //result += a[0];
        System.out.println(result);
    }
}
