package com.chyn;

import javax.script.ScriptContext;
import java.util.Scanner;

/**
 * Created by v-vetula on 5/8/2016.
 */
public class largestRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int elements = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(" ");
        int[] array = new int[elements];
        for (int index = 0; index < elements; index++) {
            array[index] = Integer.parseInt(input[index]);
        }

        //traverse from the end and calculate the max element.
        int[] maxNextToMe = new int[elements];
        maxNextToMe[elements - 1] = 0;
        int max = 0;
        for (int i = elements - 2; i >= 0; i--) {
            if (array[i] <= array[i + 1]) {
                maxNextToMe[i] = maxNextToMe[i + 1] + 1;
                int val = array[i] * (maxNextToMe[i] + 1);
                if (val > max) max = val;
            } else {
                maxNextToMe[i] = 0;
            }
        }
        System.out.print(max);

    }
}
