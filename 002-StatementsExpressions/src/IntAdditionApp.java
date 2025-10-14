/**
 * @author Onder Sahin
 */
public class IntAdditionApp {

    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter two integers to add :");

        int number1 = keyboard.nextInt();
        int number2 = keyboard.nextInt();
        int result = number1 + number2;
        System.out.printf("Result = %d", result);
    }
}
