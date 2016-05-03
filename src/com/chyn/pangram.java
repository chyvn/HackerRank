package com.chyn;

import java.util.Scanner;

/**
 * Created by chyn on 27-Apr-16.
 */
public class pangram {
    void funcion() {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().toLowerCase().split("");
        //for (int i = 0; i < input.length; i++) System.out.print(input[i].length() + " ");
        int truth[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 1; i < input.length; i++) {
            int ascii = (int) input[i].charAt(0) - 97;
            //System.out.print((ascii ) + " ");
            if (ascii >= 0 && truth[ascii] == 0) truth[ascii] = 1;
        }
        int truthValue = 0;
        for (int i = 0; i < truth.length; i++) truthValue += truth[i];
        if (truthValue == 26) System.out.println("pangram ");
        else System.out.println("not pangram" );
    }
}
