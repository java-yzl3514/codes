/**
 * @author Onder Sahin
 */
public class AdditiveOverflow {
    public static void main(String[] args) {

        int a = Integer.MAX_VALUE + 2;
        System.out.println(a);

        try {
            int result = Math.addExact(Integer.MAX_VALUE, 1);
        }catch (ArithmeticException e){
            System.out.println("Overflow is occurred !");
        }

    }
}
