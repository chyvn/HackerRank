package com.chyn;

import java.util.Scanner;

/**
 * Created by chyn on 20-May-16.
 */
public class LargestContigArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = Integer.parseInt(scanner.nextLine());
        while (iterations > 0) {
            --iterations;

            String dummy = scanner.nextLine();
            String[] input = scanner.nextLine().split(" ");
            int[] array = new int[input.length];

            int max = 0;
            int totalMax = 0;
            int localMax = 0;

            boolean isAllNeg = true;
            int negMax = Integer.MIN_VALUE;

            for (int i = 0; i < input.length; i++) {
                array[i] = Integer.parseInt(input[i]);
                if (array[i] > 0) {
                    totalMax += array[i];
                    isAllNeg = false;
                }
                if (array[i] > negMax && isAllNeg) negMax = array[i];
            }

            if (!isAllNeg) {
                for (int i = 0; i < array.length; i++) {
                    localMax = localMax + array[i];
                    if (localMax > max) max = localMax;
                    else if (localMax <= 0) localMax = 0;
                }
            }
            else{
                max = negMax;
            }

            System.out.println(max + " " + totalMax);
        }
    }
}
