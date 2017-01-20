package com.contest.varsity;

import javax.security.sasl.SaslServer;
import java.util.Scanner;

/**
 * Created by chyvn on 19-01-2017.
 */
public class Problem10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String one = scanner.nextLine();
        String two = scanner.nextLine();

        /*String out = multiply(one, 2);
        System.out.println(out);
        out = add(one, two);
        System.out.println(out);*/

        String out = "";
        String result = "0";
        int index = 0;
        for (int i = two.length() - 1; i >= 0; i--) {
            out = multiply(one, Integer.parseInt(two.charAt(i) + ""));
            for (int j = 0; j < index; j++) out = out + "0";
            result = add(out, result);
            ++index;
        }
        System.out.println(result);
    }

    public static String multiply(String in, int a) {
        String out = "";
        int carry = 0;
        int result = 0;
        for (int i = in.length() - 1; i >= 0; i--) {
            int b = Integer.parseInt(in.charAt(i) + "");
            result = b * a + carry;
            int temp = result % 10;
            carry = result / 10;
            out = temp + "" + out;
        }
        if (carry != 0) out = carry + "" + out;
        return out;
    }

    public static String add(String one, String two) {
        String out = "";
        int carry = 0;

        int i = one.length() - 1;
        int j = two.length() - 1;
        while (i >= 0 || j >= 0) {
            int a = 0, b = 0;
            if (i >= 0) a = Integer.parseInt(one.charAt(i) + "");
            if (j >= 0) b = Integer.parseInt(two.charAt(j) + "");
            int temp = a + b + carry;
            out = (temp % 10) + out;
            carry = temp / 10;
            --i;
            --j;
        }
        if (carry != 0) out = carry + out;
        return out;
    }
}
