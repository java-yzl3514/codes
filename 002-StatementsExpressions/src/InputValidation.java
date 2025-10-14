/**
 * @author Onder Sahin
 */
public class InputValidation {
    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);

        int val;
        do {
            System.out.print("Please enter an integer between [1-10] : ");
            val = keyboard.nextInt();
        }
        while (val < 1 || val > 10);

        System.out.println("You entered a valid number : " + val);

        keyboard.close();
    }
}
