/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RaggedArrays {

    public static void main(String[] args) {
        int[][] arr3 = new int[3][];


        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = new int[]{i * 1 + 1, i * 2 + 2, i * 3 + 3};
        }


        for (int row = 0; row < arr3.length; row++) {
            for (int column = 0; column < arr3[row].length; column++) {
                System.out.printf("%d  ", arr3[row][column]);
            }
            System.out.println();
        }


    }
}
