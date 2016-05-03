package com.chyn;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by chyn on 24-Apr-16.
 */
public class balancedParans {
    void function() {
        Scanner scanner = new Scanner(System.in);
        int iterations = Integer.parseInt(scanner.nextLine());
        while (iterations > 0) {
            String input[] = scanner.nextLine().split("");
            Stack stack = new Stack();
            boolean isBalanced = true;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == "{" || input[i] == "(" || input[i] == "[") stack.push(input[i]);
                else {
                    if (input[i] == "}") {
                        if (stack.peek() == "{") stack.pop();
                        else {
                            isBalanced = false;
                            break;
                        }
                    }
                    if (input[i] == "]") {
                        if (stack.peek() == "[") stack.pop();
                        else {
                            isBalanced = false;
                            break;
                        }
                    }
                    if (input[i] == ")") {
                        if (stack.peek() == "(") stack.pop();
                        else {
                            isBalanced = false;
                            break;
                        }
                    }
                }
            }
            if (isBalanced) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
