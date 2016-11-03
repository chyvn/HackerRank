package com.Graph;

import java.util.Scanner;

/**
 * Created by chyvn on 01-11-2016.
 */
public class ComponentsInGraph {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] graph = new int[2 * n];
        int[] occurence = new int[n];
        int maxOcc = 0;
        int minOcc = 0;

        for (int i = 0; i < 2 * n; i++) graph[i] = -1;
        for (int i = 0; i < n; i++) occurence[i]= 0;

        for (int i = 0; i < n; i++) {
            int left = scanner.nextInt() - 1;
            int right = scanner.nextInt() - 1;

            if (graph[left] == -1) {
                if (graph[right] == -1) {
                    if (left < right) {
                        graph[left] = left;
                        graph[right] = left;
                        occurence[left] += 2;
                        if (occurence[left] < minOcc) minOcc = occurence[left];
                        if (occurence[left] > maxOcc) maxOcc = occurence[left];
                    } else {
                        graph[left] = right;
                        graph[right] = right;
                        occurence[right] += 2;
                        if (occurence[right] < minOcc) minOcc = occurence[right];
                        if (occurence[right] > maxOcc) maxOcc = occurence[right];
                    }
                } else {
                    graph[left] = right;
                    occurence[right]++;
                    if (occurence[right] < minOcc) minOcc = occurence[right];
                    if (occurence[right] > maxOcc) maxOcc = occurence[right];
                }
            } else {
                if (graph[right] == -1) {
                    graph[right] = left;
                    occurence[left]++;
                    if (occurence[left] < minOcc) minOcc = occurence[left];
                    if (occurence[left] > maxOcc) maxOcc = occurence[left];
                }
                else {
                    // take the minimum value of the two,
                    // run through the array to connect all with the max value to minimum.
                    int min, max;
                    if (right < left) {
                        min = left;
                        max = right;
                    } else {
                        max = left;
                        min = right;
                    }

                    // iterate and make all mins max.
                    //occurence[max] = 0;
                    for (int p = 0; p < 2 * n; p++) {
                        if (graph[p] == max) graph[p] = min;
                        occurence[min]++;
                        if (occurence[min] < minOcc) minOcc = occurence[min];
                        if (occurence[min] > maxOcc) maxOcc = occurence[min];
                    }
                }
            }
        }
        // have to count the occurances of each int.
        System.out.print("The array is as follows, " + graph + " and the occurances are min : " + minOcc + " max is : " + maxOcc);
    }
}
