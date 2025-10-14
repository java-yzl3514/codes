package com.ba.yzl3514.domain.final_modifier;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class A {

    private final int a = 100;

    public A(){
        //a = 90; // COMPILE-TIME ERROR
    }


    public void foo() {
        final int a;


    }
}
