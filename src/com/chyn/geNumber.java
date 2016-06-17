package com.chyn;

/**
 * Created by v-vetula on 6/3/2016.
 * <p>
 * This is the solution to problem :
 * <p>
 * A sorted array with all numbers appearing twice, but only one of them is once.
 * Find the number.
 * <p>
 * Solution : the array will be of odd length
 * so if the number is in the left half, middle number and middle + 1 will not be equal.
 * else it's in the right half.
 * Repeat the operation again.
 */
public class geNumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 2, 3, 3, 4, 4, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11};
        int left = 0, right = array.length - 1, middle = 0;
        while (left < right) {
            //check if the single digit is present in the left half or right.
            middle = (right - left) / 2;
            middle += left;
            if (array[middle] == array[middle + 1]) {
                //single number is in the left sub array
                //we'll now operate on the left array
                left = middle + 2;
            } else {
                //the number is in the right sub array.
                right = middle;
            }
        }

        System.out.println(array[left]);
    }
}
