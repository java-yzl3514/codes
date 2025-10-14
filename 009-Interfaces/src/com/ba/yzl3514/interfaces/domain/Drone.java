package com.ba.yzl3514.interfaces.domain;

import com.ba.yzl3514.interfaces.Flyable;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Drone implements Flyable {


    @Override
    public void fly() {
        System.out.println("Drone is flying...");
    }
}
