package com.ba.yzl3514.domain.geometric;

import java.awt.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Rectangle extends GeometricObject {

    private double width;
    private double height;

    public Rectangle(int width, int height) {
        this((double) width, height);
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void print() {
        System.out.printf("Rectangle { w: %.2f, h: %.2f }%n", width, height);
    }
}
