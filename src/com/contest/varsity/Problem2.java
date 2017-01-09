package com.contest.varsity;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by chyvn on 06-01-2017.
 */
public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] array = input.split(" ");
        Map<String, Integer> dict = new HashMap<>();

        BigInteger result = new BigInteger("1");
        int intRes = 1;

        for (int i = 0; i < array.length; i++) {
            if (dict.containsKey(array[i])) {
                dict.put(array[i], dict.get(array[i]) + 1);
            }
            else {
                dict.put(array[i], 1);
            }
            result = result.multiply(BigInteger.valueOf(permutate(array[i])));
            intRes *= permutate(array[i]);
        }
        int dr = 1;
        int total = 0;
        for (Map.Entry<String, Integer> entry : dict.entrySet())
        {
            if (entry.getValue() > 1) dr *= factorial(entry.getValue());
            total += entry.getValue();
        }
        int tmepRes = factorial(total) / dr;
        result = result.multiply(BigInteger.valueOf(tmepRes));
        intRes *= tmepRes;
        System.out.println(result.toString());
        System.out.println(intRes);
    }

    public static int permutate(String input) {
        int dr = 1;
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            if (dict.containsKey(input.charAt(i))) {
                dict.put(input.charAt(i), dict.get(input.charAt(i)) + 1);
            }
            else dict.put(input.charAt(i), 1);
        }
        int total = 0;
        for (Map.Entry<Character, Integer> entry : dict.entrySet())
        {
            total += entry.getValue();
            if (entry.getValue() > 1) dr *= factorial(entry.getValue());
        }
        int result = factorial(total) / dr;
        return result;
    }

    public static int factorial(int i) {
        if (i == 0) return 1;
        else return (factorial(i - 1) * i);
    }
}
