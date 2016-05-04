package com.chyn;

import java.lang.reflect.Array;
import java.util.Scanner;

/**
 * Created by v-vetula on 4/25/2016.
 */
public class dynArray {
    void function() {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] a = firstLine.split(" ");
        int N = Integer.parseInt(a[0]);
        int Q = Integer.parseInt(a[1]);

        String[] array = new String[N];
        for(int i = 0; i<N ; i++) array[i] = "0";
        int lastAns = 0;
        while (Q > 0) {
            --Q;
            String[] query = scanner.nextLine().split(" ");

            int x = Integer.parseInt(query[1]);
            int y = Integer.parseInt(query[2]);
            int index = x ^ lastAns;

            if (query[0] == "1") array[index] = array[index] + y;

            else {
                lastAns = y % (array[index].length() - 1);
                System.out.println(lastAns);
            }
        }
    }
}
