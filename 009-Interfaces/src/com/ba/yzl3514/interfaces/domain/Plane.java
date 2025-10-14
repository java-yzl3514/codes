package com.ba.yzl3514.interfaces.domain;

import com.ba.yzl3514.interfaces.Flyable;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Plane implements Flyable {


    @Override
    public void fly() {
        System.out.println("Plane is flying...");
    }

    @Override
    public void foo() {
        Flyable.super.foo();
    }
}
