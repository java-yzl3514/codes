/**
 * @author Onder Sahin
 */
public class YieldStatement {

    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer in [1-7] to match weekday or weekend : ");
        int day = keyboard.nextInt();

        String result = switch (day) {
            case 1, 2, 3, 4, 5  -> {
                System.out.println("weekday");
                yield "45";
            }
            case 6, 7 -> "Weekend";
            default -> "Invalid Day";
        };

        String result2 = switch (day) {
            case 1, 2, 4 : {
                yield "45";
            }
            case 6 : yield "Weekend";
            default : yield "Invalid Day";
        };

    }
}
