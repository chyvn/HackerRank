package com.hkr;

import java.util.Scanner;

/**
 * Created by chyn on 11-May-16.
 */
public class square {
    public static void main(String[] args) {
        int T;
        Scanner scanner = new Scanner(System.in);
        T = Integer.parseInt(scanner.nextLine());
        while (T > 0) {
            --T;
            int l, b;
            String[] array = scanner.nextLine().split(" ");
            l = Integer.parseInt(array[0]);
            b = Integer.parseInt(array[1]);
            int fac;
            if (l < b) {
                int temp = l;
                l = b;
                b = temp;
            }
            fac = b;
            while (fac > 1) {
                if (l % fac == 0) break;
                else fac--;
            }
            System.out.println((l / fac) * (b / fac));
        }
    }
}
