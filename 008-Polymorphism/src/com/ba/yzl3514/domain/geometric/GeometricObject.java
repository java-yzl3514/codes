package com.ba.yzl3514.domain.geometric;

import java.awt.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class GeometricObject {

    private Color color;

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected void bar(){
        System.out.println("GeometricObject.bar()");
    }

    public void print(){
        System.out.println("--- Geometric object info not found ---");
    }

}
