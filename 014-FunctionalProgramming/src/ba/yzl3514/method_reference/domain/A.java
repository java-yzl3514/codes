package ba.yzl3514.method_reference.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class A {

    private int a;

    public static void staticFoo(){
        System.out.println("staticFoo");
    }

    public int foo() {
        System.out.println("foo");
        return a++;
    }

    public int foo(A this,int b) {
        System.out.println("foo");
        return a++; // ?????
    }

}
