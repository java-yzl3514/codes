package com.ba.yzl3514.domain.geometric;

import java.awt.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Circle extends GeometricObject {

    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    /*
        Prints the string representation of the object
     */
    public void print() {
        System.out.printf("Circle { radius: %.2f }%n", radius);
    }
}
