package com.chyn;

import java.util.Scanner;

/**
 * Created by chyn on 27-Apr-16.
 */
public class palindrome {

    void function() {
        Scanner scanner = new Scanner(System.in);
        int iterations = Integer.parseInt(scanner.nextLine());
        while (iterations > 0) {
            --iterations;
            String[] input = scanner.nextLine().split("");
            int operations = 0;
            for (int i = 1; i < input.length+1 / 2; i++) {
                int asciiChar1 = ascii(input[i].charAt(0));
                int asciiChar2 = ascii(input[input.length - i].charAt(0));
                if (asciiChar1 > asciiChar2) {
                    input[i] = input[input.length - i];
                    operations += (asciiChar1 - asciiChar2);
                } else if (asciiChar1 < asciiChar2) {
                    input[input.length - 1] = input[i];
                    operations += (asciiChar2 - asciiChar1);
                }
            }
            System.out.println(operations);
        }
    }

    int ascii(char c) {
        return (int) c - 97;
    }
}
