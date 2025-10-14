/**
 * @author Onder Sahin
 */
public class App6_10_22_Case {
    public static void main(String[] args) {
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer : ");
        int value = keyboard.nextInt();

        if(value > 6)
            System.out.printf("%d > 6%n", value);
        if(value > 10)
            System.out.printf("%d > 10%n", value);
        if(value > 22)
            System.out.printf("%d > 22%n", value);

    }
}
