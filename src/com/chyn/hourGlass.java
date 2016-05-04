package com.chyn;

import java.util.Scanner;

/**
 * Created by v-vetula on 4/25/2016.
 */
public class hourGlass {
    void function() {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];

        //reading the matrix.
        for (int arr_i = 0; arr_i < 6; arr_i++) {
            for (int arr_j = 0; arr_j < 6; arr_j++) {
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        int max = 0;
        //find an hour glass.
        for (int x = 0; x <= 3; x++) {
            for (int y = 0; y <= 3; y++) {
                int sum = 0;
                sum = arr[x][y] + arr[x][y + 1] + arr[x][y + 2] + arr[x + 1][y + 1] + arr[x + 2][y] + arr[x + 2][y + 1] + arr[x + 2][y + 2];
                if(sum > max) max = sum;
            }
        }
        System.out.print(max);
    }
}
