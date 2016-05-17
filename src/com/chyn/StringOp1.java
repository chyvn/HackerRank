package com.chyn;

/**
 * Created by v-vetula on 5/17/2016.
 */
public class StringOp1 {
    /**
     * Need to write a function that gives out the number of unique strings
     * formed by combining characters of two strings of length m an n.
     * condition being, the order of characters appearing in the output
     * should not change.
     */

    int noOutput(int m, int n) {
        /*
        * need to return [(m+n)! / m! * n! ]*/
        return 0;
    }

    //to implement the above function recursively.
    private static int noOutputRec(int len1, int len2, int[][] array) {
        if (array[len1][len2] != 0) return array[len1][len2];
        else {
            if (len1 == 0 || len2 == 0) {
                array[len1][len2] = 1;
                return 1;
            } else {
                array[len1][len2] = (noOutputRec(len1 - 1, len2, array) + noOutputRec(len1, len2 - 1, array));
                return array[len1][len2];
            }
        }
    }

    /**
     * To write a function that prints all strings of length m+n formed
     * from characters of two strings of length m and n, condition being,
     * the order of characters appearing in the output should not change.
     */
    private static void print(String prefix, String s1, String s2) {
        if (s1.equals("")) System.out.println(prefix + s2);
        else if (s2.equals("")) System.out.println(prefix + s1);
        else {
            print(prefix + s1.charAt(0), s1.substring(1), s2);
            print(prefix + s2.charAt(0), s1, s2.substring(1));
        }
    }

    public static void main(String[] args) {
        String string1, string2;
        string1 = "fyufyufuuiotuty";
        string2 = "fghjfkjhfh";
        int[][] array = new int[string1.length() + 1][string2.length() + 1];
       // print("", string1, string2);
        System.out.println("Total number of string is : " + noOutputRec(string1.length(), string2.length(), array));
    }

}
