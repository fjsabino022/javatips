package com.fsabino.javacodingtips.app_codility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayChainLink {

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 5;
        A[1] = 2;
        A[2] = 4;
        A[3] = 6;
        A[4] = 3;
        A[5] = 7;

        int result = solution(A);

        System.out.println(result);
    }

    private static int solution(int[] a) {
        int lengthArray = a.length;

        List<Integer> strengths = new ArrayList<>();

        int count = 0;
        for (int P = 1; P < a.length - 1; P++) {
            for (int Q = P + 1; Q < a.length - 1; Q++) {
                count++;
                if (isPGreaterThan0(P) && isQGreaterThanP(P, Q) && isQLessThanLengthMinus1(Q, lengthArray)) {
                    if (isQMinusPGreaterThan1(P, Q)) {
                        System.out.println("P: "+ P + " Q: " + Q);
                        strengths.add(a[Q] + a[P]);
                    }
                }
            }
        }

        Collections.sort(strengths);
        return strengths.get(0);
    }

    private static boolean isPGreaterThan0(int P) {
        return P > 0;
    }

    private static boolean isQGreaterThanP(int P, int Q) {
        return Q > P;
    }

    private static boolean isQLessThanLengthMinus1(int Q, int length) {
        return Q < length - 1;
    }

    private static boolean isQMinusPGreaterThan1(int P, int Q) {
        return Q - P > 1;
    }
}
