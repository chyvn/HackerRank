package com.chyn;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by chyn on 24-Apr-16.
 */
public class maxOnStack {
    void mainFunction(){
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        Stack maxStack = new Stack();
        int iterations = Integer.parseInt(scanner.nextLine());
        while(iterations > 0){
            --iterations;
            int operation, data = 0;
            String rawInput = scanner.nextLine();
            String a[] = rawInput.split(" ");
            operation = Integer.parseInt(a[0]);
            if(operation == 1) data = Integer.parseInt(a[1]);
            if(operation == 1){
                if(stack.size() == 0){
                    stack.add(data);
                    maxStack.add(data);
                }
                else{
                    stack.add(data);
                    int max = (int)maxStack.peek();
                    if(data >= max) maxStack.push(data);
                }
            }
            if(operation == 2){
                int top=(int) stack.pop();
                if((int)maxStack.peek() == top) maxStack.pop();
            }
            if(operation == 3) System.out.println((int)maxStack.peek());
            if(stack.size()>0) System.out.println("\n\n\nEnd of operation :" + operation + iterations + "\nsize of Main stack: " + stack.size() +
                    "\nSize of max stack: " + maxStack.size() +
                    "\nmax stack top : " + maxStack.peek() +
                    "\nmain stack top : " + stack.peek());
        }
    }
}
