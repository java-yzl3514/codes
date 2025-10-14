/**
 * @author Onder Sahin
 */
public class ReadingKeyboard {
    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in); // stdin
        System.out.println("Please enter two integers values : ");

        int value = keyboard.nextInt();
        int value2 = keyboard.nextInt();
        System.out.println("You entered : " + value);
        System.out.println("And : " + value2);

        keyboard.close(); // Sistem kaynaklarının doğru kullanımı için
    }
}
