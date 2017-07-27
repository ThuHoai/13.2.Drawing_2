package com.example.hoaiktt.drawing2;

import java.util.Random;

/**
 * Created by hoaiktt on 7/27/2017.
 */

public class RandomUntils {
    private static Random r = new Random();

    public static int randomInt(int n) {
        return (r.nextInt(n));
    }

    public static int randomIndex(Object[] array) {
        return (randomInt(array.length));
    }

    public static <T> T randomElement(T[] array) {
        return (array[randomIndex(array)]);
    }
}
