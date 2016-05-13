package com.chyn;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by v-vetula on 5/13/2016.
 */
public class Notepad {

    private static String S;
    private static Stack<Ops> undoStack;

    Notepad() {
        S = "";
        undoStack = new Stack<>();

    }

    private static class Ops {
        String operation;
        String operand;

        Ops(String a, String b) {
            operand = b;
            operation = a;
        }
    }

    private static void append(String input) {
        S += input;
        Ops ops = new Ops("2", input.length() + "");
        undoStack.push(ops);
    }

    private static void erase(String input) {
        int indexFrom = Integer.parseInt(input);
        int indexTo = S.length() - 1;
        indexFrom = indexTo - indexFrom;

        String cut = S.substring(indexFrom, indexTo);
        S = S.substring(0, indexFrom);
        Ops ops = new Ops("1", cut);
        undoStack.push(ops);
    }

    private static char get(String input) {
        return S.charAt(Integer.parseInt(input) - 1);
    }

    private static void undo() {

    }
    /*
    1. append(W). append this string behind S.
    2. erase(k). erase kth character on S.
    3. get(k). kth character on string S.
    4. undo(). (get has no effect on undo()).
    * */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ops = Integer.parseInt(scanner.nextLine());

        while (ops > 0) {
            --ops;

            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals('1')) append(command[1]);
            if (command[0].equals('2')) erase(command[1]);
            if (command[0].equals('3')) get(command[1]);
            if (command[0].equals('4')) undo();
        }
    }
}
