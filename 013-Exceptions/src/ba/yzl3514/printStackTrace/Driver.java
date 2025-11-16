package ba.yzl3514.printStackTrace;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        Foo foo = new Foo(new Bar());
        try {
            foo.foo();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace(System.out);
        }
    }
}
