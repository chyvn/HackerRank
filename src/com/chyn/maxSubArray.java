package com.chyn;

/**
 * Created by v-vetula on 5/5/2016.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int n = 20;
        int[] a = {1, 2, 3, 20, 1, 2, 3, 2, 1, 2, 3, 2, 1, 2, 3, 2, 1, 2, 3, 2, 1};
        int m = 5;

        //created a small sub array.
        int[] subArray = new int[m];
        int max = 0;
        for (int i = 0; i < m; i++) {
            subArray[i] = a[i];
            max += a[i];
        }

        //iterate over the entire array and find max sum.
        int temp = max;
        int index = 0;
        for (int i = 0; i < n - m; i++) {
            temp -= a[i];
            temp += a[i + m];
            if (temp > max) {
                max = temp;
                index = i + 1;
            }
        }

        System.out.println(max);
        for (int i = index; i < index + m; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
