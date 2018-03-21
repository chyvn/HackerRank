package com.interviewBit;

/*
 * Back tracking colorful number.
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 1; i <= input.length(); i++) {
            int j = 0;
            while (j + i <= input.length()) {
                hashMap.put(input.substring(j, i + j), getProduct(input.substring(j, i + j)));
                ++j;
            }
        }
        boolean isColorful = true;
        Set<String> numbers = hashMap.keySet();
        HashMap<Integer, Integer> values = new HashMap<>();

        for (String a : numbers) {
            if (values.get(hashMap.get(a)) == null) values.put(hashMap.get(a), 1);
            else {
                isColorful = false;
                break;
            }
        }

        if (isColorful) System.out.print(1);
        else System.out.print(0);
    }

    static int getProduct(String a) {
        int num = Integer.parseInt(a);
        int prod = 1;
        while (num != 0) {
            prod *= num % 10;
            num = num / 10;
        }
        return prod;
    }

}
