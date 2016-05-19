package com.chyn;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by v-vetula on 5/17/2016.
 */
public class maxSubSequence {

    /**
     * This function gives out the sequence that forms the maximum possible sum
     * in an array. Works with negative numbers as well
     */

    private static class subArray {
        int startIndex;
        int endIndex;
        int sum;


        public subArray(int startIndex, int endIndex, int sum) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer iterations = Integer.parseInt(scanner.nextLine());
        while (iterations > 0) {
            --iterations;
            String nothing = scanner.nextLine();
            String[] array = scanner.nextLine().split(" ");
            int[] input = new int[array.length];
            int totalSum = 0;
            for (int index = 0; index < array.length; index++) {
                input[index] = Integer.parseInt(array[index]);
                if (input[index] > 0) totalSum = totalSum + input[index];
            }

            int startIndex = 0;
            int maxValue = input[0], maxIndex = 1;
            int tempMax = maxValue;
            Stack<subArray> subArrayStack = new Stack<>();


            //have to handle the case where all of the given numbers are negative.

            for (int i = 1; i < input.length; i++) {
                tempMax = tempMax + input[i];
                if (tempMax > 0) {
                    if (tempMax > maxValue) {
                        maxValue = tempMax;
                        maxIndex = i;
                    }
                } else {
                    //here the sub array ends. as the value has decreased below our level of interest.
                    subArray temp = new subArray(startIndex, maxIndex, maxValue);
                    subArrayStack.push(temp);

                    //finding the next positive element on array
                    while (input[i] <= 0) ++i;

                    //new sub array starts here.. so resetting values of start index, temp max etc.
                    startIndex = i;
                    tempMax = input[i];
                    ++i;
                }
            }

            if (tempMax == maxValue) {
                System.out.println("The maximum value is found on the last iteration");
            }

            subArray temp = null;
            while (!subArrayStack.empty()) {
                temp = subArrayStack.pop();
                startIndex = temp.startIndex;
                maxIndex = temp.endIndex;
                if (maxValue == temp.sum) break;
            }

            System.out.println(maxValue + " " + totalSum);


            System.out.print("The maximum sub array is found to be : ");
            for (int i = startIndex; i <= maxIndex; i++) System.out.print(input[i] + " ");
            System.out.println("");
            System.out.print("The sum is : " + maxValue);

        }
    }
}
