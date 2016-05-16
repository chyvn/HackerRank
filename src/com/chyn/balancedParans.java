package com.chyn;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by chyn on 24-Apr-16.
 */
public class balancedParans {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = Integer.parseInt(scanner.nextLine());
        while (iterations > 0) {
            --iterations;
            String input[] = scanner.nextLine().split("");
            Stack stack = new Stack();
            boolean isBalanced = false;
            for (int i = 1; i < input.length; i++) {
                if (input[i].equals("{" + "") || input[i].equals("[" + "") || input[i].equals("(" + "")) {
                    stack.push(input[i]);
                    isBalanced = false;
                } else {
                    if (stack.size() > 0) {
                        if (input[i].equals("}" + "")) {
                            if (stack.pop().equals("{" + "")) isBalanced = true;
                            else {
                                isBalanced = false;
                                break;
                            }
                        }
                        if (input[i].equals("]" + "")) {
                            if (stack.pop().equals("[" + "")) isBalanced = true;
                            else {
                                isBalanced = false;
                                break;
                            }
                        }
                        if (input[i].equals(")" + "")) {
                            if (stack.pop().equals("(" + "")) isBalanced = true;
                            else {
                                isBalanced = false;
                                break;
                            }
                        }
                    }
                }
            }
            if (isBalanced) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
