/**
 * @author Onder Sahin
 */
public class BeforeJava5Boxing {

    public static void main(String[] args) {


        // Integer ab = new Integer(45); // DEPRECATED with JAVA 9

        Integer ab = Integer.valueOf(45); // BOXING
        int result = + ab.intValue() ; // UNBOXING
        Integer r = Integer.valueOf(result);

    }
}
