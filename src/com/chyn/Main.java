package com.chyn;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // write your code here
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
        for(int i = 0; i<100; i++) if(a[i] != -1) System.out.print(" " + a[i] + " " + "index " + i);

        Scanner scanner = new Scanner(System.in);
        int inputs = Integer.parseInt(scanner.nextLine());
        while (inputs > 0) {
            --inputs;
            int n = Integer.parseInt(scanner.nextLine());
            int j = 0; int i = 1;
            while (i != n) {
                if (a[j] != -1) ++i;
                ++j;
            }
            System.out.println(a[j] +" " + j);
        }
    }

}
