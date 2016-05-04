package com.chyn;

import java.util.Scanner;

/**
 * Created by v-vetula on 5/3/2016.
 */
public class JDq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int m = Integer.parseInt(line1.split(" ")[1]);
        int[] array = new int[n];
        line1 = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(line1.split(" ")[i]);
        }
        //declare subarray
        int[] subArray = new int[m];
        for (int i = 0; i < n - m; i++) {
            int index = 0;
            for (int j = i; j < i + m; j++) {
                subArray[index] = array[j];
                ++index;
            }
            for(int j = 0; j<subArray.length; j++){

            }
        }
        //iterate over main array with subarray times.
        //check number of unique entries.
        //if unique is m quit, else keep the next max.
    }
}
