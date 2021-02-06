package com.fsabino.javacodingtips.app_codility;

import java.util.Arrays;

public class BiggestNumberRepetitions {

    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 5;
        A[1] = 5;
        A[2] = 5;
        A[3] = 5;
        A[4] = 5;

        int result = solution(A);

        System.out.println(result);
    }

    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Arrays.sort(A);
        for (int i = A.length; i-- > 0;) {
            int numberOfTimes = A[i];
            if (isNumberInTheArrayNumberOfTimes(A, numberOfTimes)) {
                return numberOfTimes;
            }
        }
        return 0;
    }

    private static boolean isNumberInTheArrayNumberOfTimes(int[] array, int numberOfTimes) {
        int count = 0;
        for (int numberToEvaluate: array) {
            if (numberToEvaluate == numberOfTimes) {
                count++;
            }
        }
        return numberOfTimes == count;
    }
}
