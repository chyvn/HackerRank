package com.chyn;

import java.util.Scanner;

/**
 * Created by chyn on 21-May-16.
 */
public class squarePieces {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());

        while (i > 0) {
            --i;
            String[] temp = scanner.nextLine().split(" ");
            int x = Integer.parseInt(temp[0]);
            int y = Integer.parseInt(temp[1]);

            if (x == y) System.out.println(1);
            else {
                int product = x * y;
                int p = 1;
                int min = 1;
                while (p < product ) {
                    if (product % (p * p) == 0) min = product / (p * p);
                    ++p;
                }
                System.out.println(min);
            }
        }
    }
}
