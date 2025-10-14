/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class MultiDimensionalArrayInitializationSyntax {

    public static void main(String[] args) {


        int[][] matrix = {
                {34,56},
                {100, 600}
        };

        for(int row = 0; row < matrix.length; row ++){
            for(int column = 0; column < matrix[row].length ; column++){
                System.out.printf("%d  ", matrix[row][column]);
            }
            System.out.println();
        }

        System.out.println("-------------------------");

        int[][] arr = new int[][]{ {21, 67}, {23, 67, 56} };

        for(int row = 0; row < arr.length; row ++){
            for(int column = 0; column < arr[row].length ; column++){
                System.out.printf("%d  ", arr[row][column]);
            }
            System.out.println();
        }


    }
}
