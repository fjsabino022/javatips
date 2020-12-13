package com.fsabino.javacodingtips.app_codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BiggestNumberRepetitions {

    public static void main(String[] args) {
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 8;
        A[2] = 2;
        A[3] = 3;
        A[4] = 3;

        int result = solution(A);

        System.out.println(result);
    }

    public static int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        Integer[] numbers = new Integer[A.length];
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = A[i];
        }
        List<Integer> sortedNumbers = Arrays.asList(numbers);
        Collections.sort(sortedNumbers);
        for (int i = sortedNumbers.size(); i-- > 0; ) {
            Integer numberToEvaluate = sortedNumbers.get(i);
            if (isNumberNumberTimesInTheList(sortedNumbers, numberToEvaluate)) {
                return numberToEvaluate;
            }
        }
        return 0;
    }

    private static boolean isNumberNumberTimesInTheList(List<Integer> numbersOrdered, Integer number) {
        long times = numbersOrdered.stream()
                .filter(number::equals)
                .count();
        int timesToCompare = Math.toIntExact(times);
        return number == timesToCompare;
    }
}
