package com.chyn;

import java.util.Scanner;

/**
 * Created by v-vetula on 5/3/2016.
 */
public class Primes2 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // write your code here
        int[] a = new int[1100001];
        int index = 0;
        for (int i = 0; i < 1100001; i++) a[i] = i;
        for (int i = 2; i < a.length; i++) {
            if (a[i] != -1) {
                for (int j = 2; (j * a[i]) < a.length; j++) {
                    a[j * a[i]] = -1;
                }
            }
        }
        int[] primes = new int[90000];
        int j = 1;
        primes[0] = 1;
        for (int i = 2; i < a.length; i++)
            if (a[i] != -1) {
                primes[j] = a[i];
                System.out.println(j + " th prime is " + primes[j]);
                ++j;
            }
        //for (int i = 0; i < primes.length; i++) System.out.print(" " + primes[i] + " index is " + i);
        Scanner scanner = new Scanner(System.in);
        int inputs = Integer.parseInt(scanner.nextLine());
        while (inputs > 0) {
            --inputs;
            int n = Integer.parseInt(scanner.nextLine());
            long output = 0;
            int i = 1;
            while (true) {
                output += primes[i];
                ++i;
                if (primes[i] > n) break;
            }
            System.out.println(output);
        }
    }
}
