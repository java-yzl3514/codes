package com.ba.yzl3514.interfaces;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public abstract interface Executable {

    static final String NAME = "Linux";

    public abstract void execute();

    default void run(){
        System.out.println("Executable.run()");
    }

    // Java 9 +
    private void bar(){

    }
}
