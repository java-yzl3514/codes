/**
 * @author Onder Sahin
 */
public class NegativePositiveApp {

    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer : ");
        int value = keyboard.nextInt();
        /*
        if(value > 0)
            System.out.println("Positive");
        else if (value == 0)
            System.out.println("Zero");
        else if(value < 0)
            System.out.println("Negative");
         */

        if(value > 0)
            System.out.println("Positive");
        else if (value == 0)
            System.out.println("Zero");
        else
            System.out.println("Negative");

        keyboard.close(); // Sistem kaynaklarının doğru kullanımı için
    }
}
