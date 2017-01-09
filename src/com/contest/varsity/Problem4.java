package com.contest.varsity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by chyvn on 08-01-2017.
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int array[] = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            array[i] = Character.getNumericValue(input.charAt(i));
        }
        boolean happened = false;
        for (int i = input.length() - 2; i >= 0; i--) {
            int a = array[i];
            int b = array[i + 1];
            if (a < b) {
                happened = true;
                Arrays.sort(array, i, input.length());
                for (int j = i; j < input.length(); j++) {
                    if (array[j] == a && array[j + 1] > a) {
                        int temp = array[j + 1];
                        array[j + 1] = array[i];
                        array[i] = temp;
                        break;
                    }
                }
                Arrays.sort(array, i + 1, input.length());
                break;
            }
        }
        if (!happened) System.out.print("Another combination is not possible with this number");
        else {
            for (int i = 0; i < input.length(); i++) {
                System.out.print(array[i]);
            }
        }
    }
}
