package exercise;

import java.util.Arrays;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ArrayUtilTest {

    public static void main(String[] args) {

        int[] arr = ArrayUtil.generateRandomIntArray(10,0, 10);

        //System.out.println(Arrays.toString(arr));
        ArrayUtil.print(arr);
        ArrayUtil.printV2(arr);

        int[][] matrix = ArrayUtil.generateRandomMatrix(4,5,0,100);

        ArrayUtil.print(matrix);

    }
}
