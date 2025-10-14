package com.ba.yzl3514.domain.data_fields;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class B extends A{
    public int a = 90;
    public int b = 40;
    public int finalField = 89;

    @Override
    public void foo() {
        System.out.println("B.foo");
        method();
    }

    public static void method() {
        System.out.println("B.static.method");
    }
}
