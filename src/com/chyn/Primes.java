package com.chyn;

import java.util.Scanner;

/**
 * Created by chyn on 03-May-16.
 */
public class Primes {
    public void function() {
        int[] a = new int[100000];
        int index = 0;
        for (int i = 0; i < 100000; i++) a[i] = i + 2;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] % a[i] == 0) a[j] = -1;
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        int inputs = Integer.parseInt(scanner.nextLine());
        while (inputs > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            int j = 0;
            while (n > 0) {
                if (a[j] == -1) ++j;
                ++j;
                --n;
            }
            System.out.println(a[j]);
        }
    }
}
