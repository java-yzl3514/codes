import java.math.BigInteger;

/**
 * @author Onder Sahin
 */
public class BigIntegerOperation {

    public static void main(String[] args) {

        double i = 212412411231234124124124512512412312312341312312312312151627243224124124124124124124124.D;
        System.out.println(i);
        BigInteger operand1 = new BigInteger("212412411231234124124124512512412312312341312312312312151627243224124124124124124124124");
        BigInteger operand2 = new BigInteger("2");

        BigInteger result = operand1.multiply(operand2);

        System.out.println(result);
    }
}
