package com.ba.yzl3514.domain.composition;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Car {

    private Engine engine = new Engine();

    public void start(){
        engine.start();
    }

    public void stop(){
        engine.stop();
    }

    public void accelerate(){
        engine.accelerate();
    }

}
