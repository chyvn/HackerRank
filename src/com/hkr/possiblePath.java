package com.hkr;

import java.util.Scanner;

/**
 * Created by v-vetula on 5/10/2016.
 */
public class possiblePath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        while (T > 0) {
            --T;
            //your code goes here.
            int a, b, p, q;
            String[] input = scanner.nextLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            p = Integer.parseInt(input[2]);
            q = Integer.parseInt(input[3]);

            boolean is = true;
            if (a == b) {
                if (p > b) if (p % b != 0) is = false;
                if (p < b) if (b % p != 0) is = false;
                if (q > a) if (p % b != 0) is = false;
                if (q < a) if (b % p != 0) is = false;
            } else if (a > b) {

            } else {

            }
            if (is) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
