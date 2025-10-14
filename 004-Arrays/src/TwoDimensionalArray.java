/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class TwoDimensionalArray {

    public static void main(String[] args) {


        int[][] matrix = new int[2][2];

        System.out.println("length : " + matrix.length);

        for(int row = 0; row < matrix.length; row ++){
            for(int column = 0; column < matrix[row].length ; column++){
                System.out.printf("%d  ", matrix[row][column]);
            }
            System.out.println();
        }


    }
}
