package com.interviewBit;

import java.util.ArrayList;

public class Problem2 {

    public static int findMedian(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        for (int i = 1; i < n; i++) {
            int m = A.get(i).size() + A.get(i).size() * i;
            for (int j = 0; j < m; j++) {

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(3);
        temp.add(5);
        A.add(temp);
        temp = new ArrayList<>();
        temp.add(2);
        temp.add(6);
        temp.add(9);
        A.add(temp);
        temp.add(3);temp.add(6);temp.add(9);
        A.add(temp);
        System.out.print(findMedian(A));
    }
}
