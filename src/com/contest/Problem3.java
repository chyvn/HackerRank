package com.contest;

import java.util.Scanner;

/**
 * Created by chyvn on 02-11-2016.
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            --n;
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int d = scanner.nextInt();
            int rem = d % b;
            int output = 0;

            if (rem == 0) output = d / b;
            else {
                if (d / b == 0) { // this means d < b
                    if (d == a) output = 1; // this means d is a
                    else output = 2;        // this means we have to form a triangle.
                }
                else { // d is more than b.
                    output = (d / b) + 1; // here, we will reach till a point where
                    //we are left with d + remainder. and we can be sure that d + remainder > 2d.
                    // a triangle can be formed with this value. so this should work.
                }
            }


            //this logic is to find any other pattern present.
            int res = 99999999;
            for (int i = 0; i < d / b; i++) {
                if ((d - (b * i)) % a == 0) {
                    res = i + ((d - (b * i)) / a);
                }
            }

            if (output < res) System.out.println(output);
            else System.out.println(res);
        }
    }

}
