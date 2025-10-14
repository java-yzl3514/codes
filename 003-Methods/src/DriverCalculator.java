/**
 * @author Onder Sahin
 */
public class DriverCalculator {


    public static void main(String[] args) {

        System.out.println(Calculator.add(1, 1)); // Calculator.add(int, int)

        System.out.println(Calculator.add(10.5, 4)); // Calculator.add(double, double)

        System.out.println(Calculator.add(10.5, 4F)); // Calculator.add(double, double)

        System.out.println(Calculator.add((byte)1, (byte)2)); //Calculator.add(int,int)
    }
}
