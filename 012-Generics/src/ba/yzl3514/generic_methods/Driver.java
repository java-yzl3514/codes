package ba.yzl3514.generic_methods;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
        genericMethods.foo();
        genericMethods.foo(""); // type argument inference
        genericMethods.foo(1); // type argument inference
        genericMethods.foo(1.); // type argument inference
        genericMethods.foo('a'); // type argument inference
        genericMethods.foo(genericMethods); // type argument inference

    }
}
