package ba.yzl3514.domain.dot_this;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public void bar() {

        main(new String[]{});
    }


    public static void main(String[] args) {


        new Outer().new Inner().foo();


    }
}
