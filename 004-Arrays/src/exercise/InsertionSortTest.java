package exercise;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class InsertionSortTest {
    public static void main(String[] args) {


        int[] arr = ArrayUtil.generateRandomIntArray(1_000_000);
        ArrayUtil.print(arr);
        ArrayUtil.insertionSort(arr);
        ArrayUtil.print(arr);

    }
}
