package com.ba.yzl3514.domain.final_modifier.override;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class B extends A{

    public void foo() {

    }

    /*
    CAN NOT OVERRIDE
    @Override
    public void bar(){

    }
     */

   // @Override !!!! CAN NOT !!!
    public static void staticMethod(){
        System.out.println("B.staticMethod");
    }
}
