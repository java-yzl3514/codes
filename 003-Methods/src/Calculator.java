/**
 * @author Onder Sahin
 */
public class Calculator {


    public static double add(int operand1, int operand2) {
        System.out.println("add(int,int)");
        return operand1 + operand2;
    }

    public static double add(long operand1, long operand2) {
        System.out.println("add(long,long)");
        return operand1 + operand2;
    }

    /*
    Is Overloading ? NO !!

    public static int add(int operand1, int operand2) {
        System.out.println("add(int,int)");
        return operand1 + operand2;
    }
     */

    public static double add(double operand1, double operand2) {
        System.out.println("add(double, double)");
        return operand1 + operand2;
    }

    public static double add(int operand1, double operand2) {
        System.out.println("add(int, double)");
        return operand1 + operand2;
    }

    public static double add(double operand1, int operand2) {
        System.out.println("add(double, int)");
        return operand1 + operand2;
    }

}
