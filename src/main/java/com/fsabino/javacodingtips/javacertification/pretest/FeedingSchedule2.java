package com.fsabino.javacodingtips.javacertification.pretest;

public class FeedingSchedule2 {
    public static void main(String[] args) {
        int x = 5, j = 0;
        for (int i = 0; i < 3; )
            do {
                i++;
                x++;
                if (x > 10) break; // el break finaliza el bucle donde esta situado
                x += 4;
                j++;
            } while (j <= 2);
        System.out.println(x);
        // terminara con 12
    }
}
