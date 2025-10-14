/**
 * @author Onder Sahin
 */
public class FactorialApp {

    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer (n) to calculate n! : ");
        int n = keyboard.nextInt();
        long result = 1;

        for (int i = 1; i <= n; i++)
            result *= i;

        System.out.printf("%d! = %d%n", n, result);
        keyboard.close();
    }
}
