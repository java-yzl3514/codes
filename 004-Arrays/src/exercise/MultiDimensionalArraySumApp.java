package exercise;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class MultiDimensionalArraySumApp {

    public static void main(String[] args) {
        int[][] arr = readMatrixArray(3, 4);
        System.out.printf("Sum of all elements : %d%n", sumElements(arr));
    }

    public static int[][] readMatrixArray(int row, int column) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.printf("Enter integers as %d rows and %d columns :%n", row, column);
        int[][] arr = new int[row][column];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                arr[r][c] = input.nextInt();
            }
        }

        return arr;
    }

    public static long sumElements(int[][] arr) {
        long result = 0L;
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                result += arr[row][column];
            }
        }
        return result;
    }
}
