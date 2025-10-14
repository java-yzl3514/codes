package com.ba.yzl3514.domain.geometric;

import java.awt.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public abstract class GeometricObject {

    private Color color;

    public GeometricObject() {

    }

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
        System.out.println(this);
    }

    public abstract void draw();

    public abstract double area();

    @Override
    public String toString() {
        return "--- Geometric object info not found ---";
    }
}
