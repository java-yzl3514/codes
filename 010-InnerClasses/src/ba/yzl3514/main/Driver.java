package ba.yzl3514.main;

import ba.yzl3514.domain.inner.Outer;

/**
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner innerObject = outer.new Inner();
        innerObject.display();
    }
}
