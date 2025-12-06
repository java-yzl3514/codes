package ba.yzl3514.functional_interface;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
@FunctionalInterface
public interface MyFunctionalInterface {

    String foo(String arg);

    //int bar();

    boolean equals(Object o);

    int hashCode();

    default void bar(){
        System.out.println("default method");
    }
}
