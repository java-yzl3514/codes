package exercise;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class EvenBeforeOddSortTest {

    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateRandomIntArray(10);
        ArrayUtil.print(arr);
        ArrayUtil.eventBeforeOddSortV2Optimized(arr);
        ArrayUtil.print(arr);
    }
}
