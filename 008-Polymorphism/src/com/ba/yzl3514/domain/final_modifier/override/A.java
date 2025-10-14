package com.ba.yzl3514.domain.final_modifier.override;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class A {

    private void foo(){

    }

    public final void bar(){
        tar();
    }

    public void tar(){
        foo(); // it is NOT polymorphic call
    }

    public static void staticMethod(){
        System.out.println("A.staticMethod");
    }
}
