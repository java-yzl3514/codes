package com.ba.yzl3514.interfaces.domain.strings;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
import java.io.IOException;
import java.nio.CharBuffer;

import static com.ba.yzl3514.interfaces.domain.strings.RandomCharacter.*;

public class RandomWords {

    private int letterCount;

    public RandomWords(int letterCount){
        this.letterCount = letterCount;
    }

    public int getLetterCount() {
        return letterCount;
    }

    public String next(){
        StringBuilder builder = new StringBuilder();
        builder.append(nextUpper());
        for(int i = 0; i < letterCount - 1; i++)
            builder.append(nextLower());
        return builder.toString();
    }

}
