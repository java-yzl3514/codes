package com.ba.yzl3514.interfaces.domain.strings;

import java.util.Scanner;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        RandomWordsStream wordsStream = new RandomWordsStream(20, 10);
        Scanner scanner = new Scanner(wordsStream);
        while(scanner.hasNext())
            System.out.print(scanner.nextLine());
    }
}
