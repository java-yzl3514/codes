package exercise;

import java.lang.reflect.Array;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class BubbleSortTest {
    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateRandomIntArray(1_000_000);
        ArrayUtil.print(arr);
        ArrayUtil.bubbleSortV2(arr);
        ArrayUtil.print(arr);
    }
}
