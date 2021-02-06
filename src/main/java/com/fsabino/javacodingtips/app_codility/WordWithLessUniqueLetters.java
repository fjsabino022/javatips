package com.fsabino.javacodingtips.app_codility;

import java.util.*;

public class WordWithLessUniqueLetters {

    public static void main(String[] args) {
        String initial = "ccaaffddecee";

        int result = solution(initial);

        System.out.println(result);
    }

    public static int solution(String S) {
        List<Character> differentLetters = getListWithLetterJustOnceInTheString(S);

        List<Integer> occurrences = new ArrayList<>();
        int lettersDeleted = 0;

        for (Character letter: differentLetters) {
            int letterOccurrences = getOccurrencesByLetter(S, letter);
            lettersDeleted += deleteLetters(occurrences, letterOccurrences, 0);
        }

        return lettersDeleted;
    }

    private static List<Character> getListWithLetterJustOnceInTheString(String S) {
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < S.length(); i++){
            result.add(S.charAt(i));
        }
        return new ArrayList<>(result);
    }

    private static int getOccurrencesByLetter(String S, char letter) {
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    private static int deleteLetters(List<Integer> listOccurrences, int letterOccurrences, int lettersDeleted) {
        if (letterOccurrences == 0) {
            return lettersDeleted;
        }
 
        if (doesTheFrecuencyExist(listOccurrences, letterOccurrences)) {
            return deleteLetters(listOccurrences, --letterOccurrences, ++lettersDeleted);
        }

        listOccurrences.add(letterOccurrences);
        return lettersDeleted;
    }

    private static boolean doesTheFrecuencyExist(List<Integer> listOccurrences, int letterOccurrences) {
        for (Integer frequency : listOccurrences ) {
            if (frequency.equals(letterOccurrences)) {
                return true;
            }
        }
        return false;
    }
}
