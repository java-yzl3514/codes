package ba.yzl3514.rethrowing;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Rethrowing {

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
            throw e;
        }
    }

    public static void tar() throws Exception{

        try {
            foo();
        } catch (Exception e) {
            System.out.println("Inside tar(): e.printStackTrace(): ");
            e.printStackTrace(System.out);
            throw  (Exception) e.fillInStackTrace(); // origin of exception
        }
    }

    public static void main(String[] args) {
        try {
            bar();
        } catch (Exception e) {
            System.out.println("main : e.printStackTrace(): ");
            e.printStackTrace(System.out);
        }

        try {
            tar();
        } catch (Exception e) {
            System.out.println("main : e.printStackTrace(): ");
            e.printStackTrace(System.out);
        }
    }

}
