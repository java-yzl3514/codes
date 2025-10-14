/**
 * @author Onder Sahin
 */
public class SwitchExpression {

    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer in [1-7] to match weekday or weekend : ");
        int day = keyboard.nextInt();

        String result = switch (day) {
            case 1, 2, 3, 4, 5  -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid Day";
        };

        System.out.println(result);

    }
}
