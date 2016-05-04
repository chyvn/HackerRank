package com.chyn;

import java.util.Scanner;

/**
 * Created by v-vetula on 4/25/2016.
 */
public class sparceArray {
    void function() {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        String[] array = new String[1000];
        int i = 0;
        while (lines > 0) {
            --lines;
            array[i] = scanner.nextLine();
            ++i;
        }
        int queries = Integer.parseInt(scanner.nextLine());
        while (queries > 0) {
            --queries;
            String query = scanner.nextLine();
            int times = 0;
            for (int x = 0; x < i; x++) {
                if (array[x].equals(query)) ++times;
            }
            System.out.println(times);
        }
    }
}
