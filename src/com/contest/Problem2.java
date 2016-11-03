package com.contest;

import java.util.Scanner;

/**
 * Created by chyvn on 01-11-2016.
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();

        int common = 0;
        for (int i = 0; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) ++common;
            else break;
        }
        int n = s.length() + t.length() - 2 * common;
        if (n == k) System.out.print("Yes");
        if (n > k) System.out.print("No");
        if (n < k) {
            if (k - n > common) System.out.print("Yes");
            else {
                if ((k - n) % 2 == 0) System.out.print("Yes");
                else System.out.print("No");
            }
        }
    }
}
