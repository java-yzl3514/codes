/**
 * @author Onder Sahin
 */
public class DigitSumApp {

    public static void main(String[] args) {


        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer to digit sum : ");

        int val = Math.abs(keyboard.nextInt());
        int digitSum = 0;

        while(val != 0){
            digitSum += (val % 10);
            val /= 10;
        }

        System.out.printf("Sum of digits = %d%n", digitSum);

        keyboard.close(); // Sistem kaynaklarının doğru kullanımı için
    }
}
