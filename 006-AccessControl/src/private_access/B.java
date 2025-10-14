package private_access;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class B {

    private void f(){

        new A().p = 90;
        // new A().a = 100; // private access // Compile-Time Error

    }
}
