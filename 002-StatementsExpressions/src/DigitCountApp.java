/**
 * @author Onder Sahin
 */
public class DigitCountApp {
    public static void main(String[] args) {


        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer to digit count :");
        int n = keyboard.nextInt();

        int digitCount;
        if(n == 0)
            digitCount = 1;
        else {
            digitCount = 0;
            while (n != 0) {
                ++digitCount;
                n /= 10;
            }
        }

        System.out.printf("Digit Count = %d%n", digitCount);
        keyboard.close(); // Sistem kaynaklarının doğru kullanımı için
    }
}
