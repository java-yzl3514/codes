package ba.yzl3514.streams.create;

import java.util.stream.IntStream;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RangeOfInt {

    public static void main(String[] args) {

        int sum = 0;
        for(int i = 10; i < 20; i++){
            sum += i;
        }
        System.out.println(sum);

        sum = 0;
        for(int i : IntStream.range(10, 20).toArray()){
            sum += i;
        }
        System.out.println(sum);

        System.out.println(IntStream.range(10, 20).sum());

    }
}
