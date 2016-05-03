package com.chyn;

import java.util.Scanner;

/**
 * Created by chyn on 27-Apr-16.
 */
public class altChars {
    void function() {
        Scanner scanner = new Scanner(System.in);
        int iterations = Integer.parseInt(scanner.nextLine());
        while (iterations > 0) {
            --iterations;
            String[] input = scanner.nextLine().split("");
            char prevChar = input[1].charAt(0);
            int count = 0;
            for (int i = 2; i < input.length; i++) {
                if(input[i].charAt(0) == prevChar) ++count;
                prevChar = input[i].charAt(0);
            }
            System.out.println(count);
        }
    }
}
