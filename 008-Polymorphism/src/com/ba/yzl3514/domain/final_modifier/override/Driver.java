package com.ba.yzl3514.domain.final_modifier.override;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        A a = new B();
        a.staticMethod();

        A.staticMethod();

        B.staticMethod();

    }

}
