/**
 * @author Onder Sahin
 */

public class SumOfRangeCaseBeforeMethods {


    public static void main(String[] args) {

        int sum = 0;
        for(int i = 1; i <= 10; i ++){
            sum += i;
        }
        System.out.printf("Sum of range [1-10] : %d%n", sum);

        sum = 0;
        for(int i = 20; i <= 38; i ++){
            sum += i;
        }
        System.out.printf("Sum of range [20-38] : %d%n", sum);

        sum = 0;
        for(int i = 120; i <= 400; i ++){
            sum += i;
        }
        System.out.printf("Sum of range [120-400] : %d%n", sum);
    }


}
