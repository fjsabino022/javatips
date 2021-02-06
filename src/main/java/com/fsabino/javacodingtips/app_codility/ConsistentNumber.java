package com.fsabino.javacodingtips.app_codility;

import java.util.Arrays;

public class ConsistentNumber {

    public static void main(String[] args) {
        String initial = "10101";

        int result = solution(initial);

        System.out.println(result);
    }

    public static int solution(String S) {
        int length = S.length();
        int[] array = new int[length - 1];
        for (int i = 0; i <= length -2; i++) {
            array[i] = Integer.parseInt(S.substring(i, i + 2));
        }
        Arrays.sort(array);
        return array[array.length - 1];
    }
}
