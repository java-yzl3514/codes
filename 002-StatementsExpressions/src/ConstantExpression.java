/**
 * @author Onder Sahin
 */
public class ConstantExpression {

    public static void main(String[] args) {


        int a = 45 + 90;

        boolean b = !false;

        int c = -100;

        boolean d = 10 < 20;

        boolean e = true || false;

        int f = true ? 5 : 10;

        int g = a + f; // NOT CONSTANT EXPRESSION !!!!!!


        final int h = foo(); // NOT CONSTANT EXPRESSION / NOT CONSTANT VARIABLE !!!!! **** bknz: notes.txt


        final int i = 90 * 89; // CONSTANT VARIABLE !!!

        int k = i;
        int m = h;

    }

    public static int foo(){
        System.out.println("foo");
        return 100;
    }
}
