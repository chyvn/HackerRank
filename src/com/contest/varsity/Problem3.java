package com.contest.varsity;

import java.util.Scanner;

/**
 * Created by chyvn on 11-11-2016.
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        int diff[] = new int[n];
        int posIndex = 0;
        a[0] = scanner.nextInt();
        int count = 0;
        int maxConsecIndex = 0;
        int maxConsecValues = 0;
        for (int i = 1; i < n; i++) {
            a[i] = scanner.nextInt();
            diff[i] = a[i] - a[i - 1];
            //check the number of zeros from the start Index. or pos index.
            if (diff[i] < 1) {
                ++count;
                if (count > maxConsecValues) {
                    ++maxConsecValues;
                    maxConsecIndex = posIndex;
                }
            }
            else {
                count = 0;
                posIndex = i;
            }
        }
        int p = 0;
    }
}
