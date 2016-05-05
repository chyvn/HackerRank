package com.chyn;

/**
 * Created by v-vetula on 5/5/2016.
 */
public class subArrayUnique {
    public static void main(String[] args) {
        int n = 20;
        int[] a = {1, 2, 3, 20, 1, 2, 3, 2, 1, 2, 3, 2, 1, 2, 3, 19, 1, 2, 3, 4};
        int[] keyVal = new int[21];
        int m = 5;

        //created a small sub array.
        int[] subArray = new int[m];

        //find the number of unique elements.
        int unique = m;
        for (int i = 0; i < m; i++) {
            subArray[i] = a[i];
            keyVal[subArray[i]] += 1;
            if (keyVal[subArray[i]] > 1) --unique;
        }

        //iterate over the entire array and find max unique elements in a sub array.
        int index = 0;
        int max = unique;
        for (int i = 0; i < n - m; i++) {

            //if we found m unique elements, we are done.
            if (unique == m) break;

            //removing the first element from counting, as we are moving ahead with subarray
            //if the element occurs more than once in the sub array, it's value is > 1
            //if it's unique, now the value will be 0, and we lost a unique element so decrementing unique;
            keyVal[a[i]] -= 1;
            if (keyVal[a[i]] == 0) --unique;

            //adding the next element.
            //if the element has it's first occurrence in sub array, it's value is 1. so incrementing unique
            //if the element has occurred more than once. the value is not 1. need not operate on unique.
            keyVal[a[i + m]] += 1;
            if (keyVal[a[i + m]] == 1) ++unique;

            //at any point if we see m unique numbers we break
            if (unique > max) {
                max = unique;
                index = i + 1;
            }
            if (unique == m) break;


        }

        System.out.println(max);
        for (int i = index; i < index + m; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
