package com.fsabino.javacodingtips.app_codility;

import java.util.*;

public class FairIndex {

    public static void main(String[] args) {
        int[] A = new int[5];
        int[] B = new int[5];
        A[0] = 1;
        A[1] = 4;
        A[2] = 2;
        A[3] = -2;
        A[4] = 5;

        B[0] = 7;
        B[1] = -2;
        B[2] = -2;
        B[3] = 2;
        B[4] = 5;
        int result = solution(A, B);

        System.out.println(result);
    }

    public static int solution(int[] A, int[] B) {
        int lengthA = A.length;
        int lengthB = B.length;
        if (lengthA < 2 || lengthA > 100000) {
            throw new IllegalArgumentException("Length of array A is invalid");
        }
        if (lengthB < 2 || lengthB > 100000) {
            throw new IllegalArgumentException("Length of array B is invalid");
        }
        int count = 0;
        for (int i = 1; i <= lengthA -1; i++) {
           int sumFirstPartList1 = calculateSumFistPart(A, i);
           int sumSecondPartList1 = calculateSumSecondPart(A, i);
           if (sumFirstPartList1 == sumSecondPartList1) {
               int sumFirstPartList2 = calculateSumFistPart(B, i);
               int sumSecondPartList2 = calculateSumSecondPart(B, i);
               if (sumFirstPartList2 == sumSecondPartList2) {
                   if (sumFirstPartList1 == sumFirstPartList2) {
                       count+= 1;
                   }
               }
           }
       }
       return count;
    }

    private static int calculateSumFistPart(int[] numbers, int index) {
        int sum = 0;
        for (int x = 0; x <= index - 1; x++) {
            sum+= numbers[x];
        }
        return sum;
    }

    private static int calculateSumSecondPart(int[] numbers, int index) {
        int sum = 0;
        for (int x = index ; x < numbers.length; x++) {
            sum+= numbers[x];
        }
        return sum;
    }
}
