package com.hkr;

import java.util.Scanner;

/**
 * Created by v-vetula on 5/10/2016.
 */
public class maxDraws {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T > 0) {
            --T;
            //your code goes here.
            int N = Integer.parseInt(scanner.nextLine());
            if (N % 2 == 0) N = ((N / 2) * 2) + 1;
            else N = ((N / 2) * 2) + 2;
            System.out.println(N);
        }
    }
}
