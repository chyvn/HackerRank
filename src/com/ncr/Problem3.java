package com.ncr;

import java.util.Scanner;

/**
 * Created by chyvn on 07-11-2016.
 */
public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        while (iterations > 0) {
            --iterations;
            boolean isTie = true;
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            char board[][] = new char[n][m];
            boolean notDone = true;

            for (int i = 0; i < n ; i++) {
                String temp[] = scanner.next().split("");
                for (int j = 0; j < m; j++) {
                    board[i][j] = temp[j].charAt(0);
                    if (i >= k - 1 && j >= k - 1) {
                        // it's in the fourth quardrant.
                        int count = k;
                        int countX = 0;
                        int countO = 0;
                        //checking the diagonals.
                        for (int p = i, q = j; count > 0; p--, q-- , count--) {
                            if (board[p][q] == 'O') ++countO;
                            else if (board[p][q] == 'X') ++countX;
                        }
                        if (countX == k && notDone) {
                            System.out.println("LOSE");
                            notDone = false;
                        }
                        else if (countO == k && notDone) {
                            System.out.println("WIN");
                            notDone = false;
                        }


                        //checking to the left
                        count = k;
                        countX = 0;
                        countO = 0;
                        for (int p = i, q = j; count > 0; p--, --count) {
                            if (board[p][q] == 'O') ++countO;
                            else if (board[p][q] == 'X') ++countX;
                        }
                        if (countX == k && notDone) {
                            System.out.println("LOSE");
                            notDone = false;
                        }
                        else if (countO == k && notDone) {
                            System.out.println("WIN");
                            notDone = false;
                        }

                        // checking to the top
                        count = k;
                        countX = 0;
                        countO = 0;
                        for (int p = i, q = j; count > 0; q--, --count) {
                            if (board[p][q] == 'O') ++countO;
                            else if (board[p][q] == 'X') ++countX;
                        }
                        if (countX == k && notDone) {
                            System.out.println("LOSE");
                            notDone = false;
                        }
                        else if (countO == k && notDone) {
                            System.out.println("WIN");
                            notDone = false;
                        }

                    }
                    else if (i >= k - 1) {
                        // we can check to the left
                        //checking to the left
                        int count = k;
                        int countX = 0;
                        int countO = 0;
                        for (int p = i, q = j; count > 0; p--, --count) {
                            if (board[p][q] == 'O') ++countO;
                            else if (board[p][q] == 'X') ++countX;
                        }
                        if (countX == k && notDone) {
                            System.out.println("LOSE");
                            notDone = false;
                        }
                        else if (countO == k && notDone) {
                            System.out.println("WIN");
                            notDone = false;
                        }
                    }
                    else if (j >= k - 1) {
                        // we can check to the right.
                        // checking to the top
                        int count = k;
                        int countX = 0;
                        int countO = 0;
                        for (int p = i, q = j; count > 0; q--, --count) {
                            if (board[p][q] == 'O') ++countO;
                            else if (board[p][q] == 'X') ++countX;
                        }
                        if (countX == k && notDone) {
                            System.out.println("LOSE");
                            notDone = false;
                        }
                        else if (countO == k && notDone) {
                            System.out.println("WIN");
                            notDone = false;
                        }
                    }
                }
            }

            if(notDone) System.out.println("NONE");

        }
    }
}
