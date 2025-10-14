package exercise;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class SelectionSortTest {
    public static void main(String[] args) {


        int[] arr = ArrayUtil.generateRandomIntArray(1_000_000);
        ArrayUtil.print(arr);
        ArrayUtil.selectionSortMinVersion(arr);
        ArrayUtil.print(arr);
    }
}
