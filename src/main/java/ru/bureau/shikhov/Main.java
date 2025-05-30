package ru.bureau.shikhov;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] segments = new int[n][2];

        for (int i = 0; i < n; i++) {
            segments[i][0] = scanner.nextInt();
            segments[i][1] = scanner.nextInt();
        }

        int result = findMinPoints(segments);
        System.out.println(result);
    }

    private static int findMinPoints(int[][] segments) {
        Arrays.sort(segments, Comparator.comparingInt(a -> a[1]));

        int pointsCount = 0;
        int lastPoint = Integer.MIN_VALUE;

        for (int[] segment : segments) {
            int left = segment[0];
            int right = segment[1];

            if (left > lastPoint) {
                pointsCount++;
                lastPoint = right;
            }
        }

        return pointsCount;
    }
}