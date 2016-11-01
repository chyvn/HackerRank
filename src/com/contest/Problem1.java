package com.contest;

import java.util.Scanner;

/**
 * Created by chyvn on 31-10-2016.
 */
public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int gcd = 0;
        int[] a = new int[n];
        a[0] = in.nextInt();
        int lcm = a[0];
        for (int a_i = 1; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
            lcm = lcm(lcm, a[a_i]);
        }
        int[] b = new int[m];
        b[0] = in.nextInt();
        gcd = b[0];
        for (int b_i = 1; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
            if (gcd > b[b_i]) gcd = gcd(gcd, b[b_i]);
            else gcd = gcd(b[b_i], gcd);
        }

        int count = 0;
        if (gcd % lcm == 0) count = gcd / lcm;
        if (count == 1) System.out.print(count);
        else System.out.print(count - 1);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

    static int lcm(int a, int b) {
        if (a > b) return ((a * b) / gcd(a, b));
        else return ((b * a) / gcd(b, a));
    }
}
