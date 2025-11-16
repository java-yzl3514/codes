package ba.yzl3514.rethrowing;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Causing {

    public static void foo() throws Exception {
        System.out.println("Exception is thrown from foo()");
        throw new Exception();
    }

    public static void bar() throws Exception {
        try {
            foo();
        } catch (Exception e) {
            System.out.println("In bar(): e.printStackTrace() : ");
            e.printStackTrace(System.out);
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        try {
            bar();
        } catch (Exception e) {
            System.out.println("main : e.printStackTrace(): ");
            e.printStackTrace(System.out);
        }

    }
}
