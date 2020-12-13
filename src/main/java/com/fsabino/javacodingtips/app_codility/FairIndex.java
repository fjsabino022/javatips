package com.fsabino.javacodingtips.app_codility;

import java.util.*;

public class FairIndex {

    public static void main(String[] args) {
        int[] A = new int[5];
        int[] B = new int[5];
        A[0] = 0;
        A[1] = 4;
        A[2] = -1;
        A[3] = 0;
        A[4] = 3;

        B[0] = 0;
        B[1] = -2;
        B[2] = 5;
        B[3] = 0;
        B[4] = 3;

        int result = solution(A, B);

        System.out.println(result);
    }

    public static int solution(int[] A, int[] B) {
        int count = 0;
        for (int i = 1; i <= A.length -1; i++) {
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
