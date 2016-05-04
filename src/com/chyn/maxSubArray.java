package com.chyn;

import java.util.Scanner;

/**
 * Created by chyn on 04-May-16.
 */
public class maxSubArray {
    public static void main(String[] args) {
        int n = 6, m = 3;
        Scanner scanner = new Scanner(System.in);
        m = Integer.parseInt(scanner.nextLine());
        int[] array = new int[m];
        String input = scanner.nextLine();
        for(int i = 0; i<array.length; i++) array[i] = Integer.parseInt(input.split(" ")[i]);
        //ffirst let's write function for m, to check if everything is unique in this subarray.

        int count = 0;
        for(int i = 0; i<m; i++){
            boolean unique = true;
            for(int j = i+1; j<m; j++){
                if(array[i] == array[j]) unique = false;
            }
            if(unique) ++count;
        }

        System.out.print(count);
    }
}
