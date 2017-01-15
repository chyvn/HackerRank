package com.contest.varsity;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by chyvn on 09-01-2017.
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();

        int[] array = new int[26];
        for (int i = 0; i < in.length(); i++) {
            array[in.charAt(i) - 'a']++;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (array[i] > 0) {
                ++count;
                array[i] = count;
            }
        }

        int number = 0;
        for (int i = 0; i < in.length(); i++) {
            number *= 10;
            number += array[in.charAt(i) - 'a'];
        }
        int init = 0;
        for (int i = 0; i < in.length(); i++) {
            init *= 10;
            init += (i + 1);
        }
        int rank = 0;
        while (init != number) {
            ++rank;
            init = get(init + "");
            System.out.println(init);
        }
        System.out.print(rank + 1);
    }

    public static int get(String input) {
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
        int nubmer = 0;
        for (int i = 0; i < array.length; i++) {
            nubmer *= 10;
            nubmer += array[i];
        }
        return nubmer;
    }
}
