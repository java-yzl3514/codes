/**
 * @author Onder Sahin
 */
public class SumOfRangeCaseAfterMethods {

    public static void main(String[] args) {

        System.out.printf("Sum of range [1-10] : %d%n", rangeSum(1,10));
        System.out.printf("Sum of range [20-38] : %d%n", rangeSum(20,38));
        System.out.printf("Sum of range [120-400] : %d%n", rangeSum(120,400));

    }


    public static int rangeSum(int min, int max) {
        int sum = 0;
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }
}
