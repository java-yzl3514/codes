package com.ba.yzl3514.interfaces.domain.strings;

import java.io.IOException;
import java.nio.CharBuffer;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomWordsStream extends RandomWords implements Readable{

    private int wordCount;

    public RandomWordsStream(int wordCount, int letterCount){
        super(letterCount);
        this.wordCount = wordCount;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if(wordCount-- == 0)
            return -1;
        cb.append(next());
        cb.append(" ");
        return getLetterCount() + 1;
    }
}
