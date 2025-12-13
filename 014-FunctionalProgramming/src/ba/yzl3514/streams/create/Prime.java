package ba.yzl3514.streams.create;

import java.util.stream.LongStream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Prime {

    public static boolean isPrime(long number){
       return LongStream
                .rangeClosed(2,(long)Math.sqrt(number))
                .noneMatch(value -> number % value == 0);
    }

    public LongStream numbers(){
        return LongStream.iterate(2, operand -> operand + 1)
                .filter(Prime::isPrime);
    }
}
