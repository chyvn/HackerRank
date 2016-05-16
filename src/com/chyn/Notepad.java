package com.chyn;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by v-vetula on 5/13/2016.
 */
public class Notepad {

    private static String S;
    private static Stack<Ops> undoStack;

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
        if(undoStack == null){
            undoStack = new Stack<>();
        }
        undoStack.push(ops);
    }

    private static void erase(String input) {
        int indexFrom = Integer.parseInt(input) - 1;
        int indexTo = S.length() - 1;
        indexFrom = indexTo - indexFrom;

        String cut = S.substring(indexFrom, indexTo + 1);
        S = S.substring(0, indexFrom);
        Ops ops = new Ops("1", cut);
        undoStack.push(ops);
    }

    private static char get(String input) {
        System.out.println(S.charAt(Integer.parseInt(input) - 1));
        return S.charAt(Integer.parseInt(input) - 1);
    }

    private static void undo() {
        if(undoStack.size() > 0) {
            Ops ops = undoStack.pop();
            String[] s = {ops.operation, ops.operand};
            mapper(s);
        }
        //as undo is getting mapped to inverse of the operations, once the operations finished
        //it's inverse will be on top of the stack. if this is the case then the undo will keep repeating the
        //same action over and over... so removing the top of the stack.
        undoStack.pop();
    }
    /*
    1. append(W). append this string behind S.
    2. erase(k). erase kth character on S.
    3. get(k). kth character on string S.
    4. undo(). (get has no effect on undo()).
    * */

    private static void mapper(String[] command){
        if (command[0].equals('1' + "")) append(command[1]);
        if (command[0].equals('2' + "")) erase(command[1]);
        if (command[0].equals('3' + "")) get(command[1]);
        if (command[0].equals('4' + "")) undo();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ops = Integer.parseInt(scanner.nextLine());
        S = "";
        while (ops > 0) {
            --ops;

            String[] command = scanner.nextLine().split(" ");
            mapper(command);
        }
    }
}
