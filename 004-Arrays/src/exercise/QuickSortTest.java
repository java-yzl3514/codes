package exercise;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class QuickSortTest {
    public static void main(String[] args) {
        // 1_000_000_000
        int[] arr = ArrayUtil.generateRandomIntArray(1_000_000);
        ArrayUtil.print(arr);
        ArrayUtil.quickSort(arr);
        ArrayUtil.print(arr);
    }
}
