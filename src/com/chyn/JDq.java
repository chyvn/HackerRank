package com.chyn;

import java.util.Scanner;

/**
 * Created by v-vetula on 5/3/2016.
 */
public class JDq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //reading line 1, values of n and m.
        String line1 = scanner.nextLine();
        int n = Integer.parseInt(line1.split(" ")[0]);
        int m = Integer.parseInt(line1.split(" ")[1]);

        //reading line 2, the array a[n]
        int[] array = new int[n];
        line1 = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(line1.split(" ")[i]);
        }

        //declare subarray
        int[] subArray = new int[m];
        int max = 0;

        //iterate over the array till n-m to find max sub array.
        for (int i = 0; i < n - m; i++) {
            int index = 0;

            //create the sub array
            for (int j = i; j < i + m; j++) {
                subArray[index] = array[j];
                ++index;
            }

            //counting number of unique characters in this array.
            int count = 0;
            for(int k = 0; k<m; k++){
                boolean unique = true;
                for(int j = k+1; j<m; j++){
                    if(subArray[k] == subArray[j]) unique = false;
                }
                if(unique) ++count;
            }

            //updating max unique chars
            max = count;
            if(count == m) break;
        }

        //printing output.
        System.out.println(max);
    }
}
