package com.ba.yzl3514.interfaces.domain.strings;

import java.util.Random;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomWords2 {

    private int letterCount;
    private static Random random = new Random();
    private static final char[] capitals = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    //private static final char[] capitals =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };
    private static final char[] vowels = {
            'a', 'e', 'i', 'o', 'u'
    };

    public RandomWords2(int letterCount) {
        this.letterCount = letterCount;
    }

    public String next() {
        StringBuilder builder = new StringBuilder();
        builder.append(capitals[random.nextInt(capitals.length)]);
        for (int i = 0; i < letterCount - 1; i++)
            builder.append(lowers[random.nextInt(lowers.length)]);
        return builder.toString();
    }


}
