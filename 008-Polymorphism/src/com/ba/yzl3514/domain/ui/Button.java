package com.ba.yzl3514.domain.ui;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Button {

    public Button(){
        System.out.println("Before rendering");
        render(); // ATTENTION !!  polymorphic call in ctor
        System.out.println("After rendering");
    }

    public void render() {
        System.out.println("Button.render");
    }
}
