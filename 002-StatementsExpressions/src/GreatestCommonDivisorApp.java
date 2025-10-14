/**
 * @author Onder Sahin
 */
public class GreatestCommonDivisorApp {

    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter two integers to find gcd : ");

        int a = Math.abs(keyboard.nextInt());
        int b = Math.abs(keyboard.nextInt());
        System.out.printf("gcd(%d,%d) = ", a, b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        System.out.printf("%d%n", a);

        keyboard.close(); // Sistem kaynaklarının doğru kullanımı için
    }
}
