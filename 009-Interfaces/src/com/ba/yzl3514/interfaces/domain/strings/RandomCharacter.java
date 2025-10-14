package com.ba.yzl3514.interfaces.domain.strings;


import java.util.Random;

/**
 * @author Onder Sahin
 */
public class RandomCharacter {
    private static Random random;

    static {
        random = new Random();
    }

    public static char nextLower() {
        return next('a', 'z');
    }

    public static char nextUpper() {
        return next('A', 'Z');
    }

    public static char nextDigit() {
        return next('0', '9');
    }

    public static char next() {
        return next('\u0000', '\uFFFF');
    }

    public static char nextVowel(){
        // TODO
        return ' ';
    }

    /*
    public static char next(char from, char to) {
        return (char) (from + (Math.random() * (to - from + 1)));
    }
     */

    /*
    public static char next(char from, char to) {
        java.util.Random random = new java.util.Random();
        return (char) random.nextInt(from, to + 1);
    }
     */

    public static char next(char from, char to) {
        return (char)(from + (random.nextInt(to - from + 1)));
    }
}
