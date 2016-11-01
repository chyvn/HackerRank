package com.contest;

import java.util.Scanner;

/**
 * Created by chyvn on 31-10-2016.
 */
public class Problem1V0 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }

        int aMax = a[0];
        for (int i = 0; i < n; i++) if (aMax < a[i]) aMax = a[i];
        int bMin = b[0];
        for (int i = 0; i < m; i++) if (bMin > b[i]) bMin = b[i];

        int count = 0;
        for (int i = aMax; i <= bMin; i++) {
            boolean isFactor = true;
            for (int j = 0; j < m && isFactor; j++) if (b[j] % i != 0) isFactor = false;
            for (int p = 0; p < n && isFactor; p++ ) if (i % a[p] != 0) isFactor = false;
            if (isFactor) count++;
        }
        System.out.print(count);
    }
}
