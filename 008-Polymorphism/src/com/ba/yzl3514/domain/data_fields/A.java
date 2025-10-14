package com.ba.yzl3514.domain.data_fields;

/**
 *
 * Hiding
 *
 * @author Onder Sahin
 *
 */
public class A {
    public int a = 100;
    public int b = 900;
    public final int finalField = 11;


    public void foo() {
        System.out.println("A.foo");
        method();
    }

    public static void method(){
        System.out.println("A.static.method");
    }
}
