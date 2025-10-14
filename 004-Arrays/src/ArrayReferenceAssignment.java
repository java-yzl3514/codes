/**
 * @author Onder Sahin
 */
public class ArrayReferenceAssignment {
    public static void main(String[] args) {

         //int[] numbers = new short[10]; // COMPILE-TIME ERROR
        // short[] numbers = new int[10]; // COMPILE-TIME ERROR

        Object[] objects = new String[10];

        String[] strArray = {"Ankara", "Istanbul"};
        Object[] objArray = strArray; // Geçerli

        //....

        objArray[0] = "İzmir";
        objArray[1] = 45;


        Object arr = new int[3];

        Object[] arrMulti = new int[2][2];

    }
}
