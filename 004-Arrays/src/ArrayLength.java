/**
 * @author Onder Sahin
 */
public class ArrayLength {

    public static void main(String[] args) {

        int[] numbers = new int[10];
        System.out.println("The length of numbers array is " + numbers.length);
        // numbers.length = 20; // COMPILE-TIME ERROR

        int[] numbers2 = new int[20];

        int[] a = new int[-0];
        System.out.println(-0);
        System.out.println(-0.);
    }
}
