package com.ba.yzl3514.interfaces.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public abstract class Software {

    public void run(){
        System.out.println("Software.run()");
    }

    public void execute(){
        System.out.println("Software is running...");
    }

    public static void staticMethod(){
        System.out.println("Software.staticMethod");
    }
}
