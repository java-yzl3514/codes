package com.ba.yzl3514.domain.geometric;

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

    public Rectangle() {
        this(2,1);
    }

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

    @Override
    public void bar(){
        System.out.println("Rectangle.bar()");
        //super.bar();
    }

    @Override
    public void draw() {
        System.out.println("Rectangle Drawing...");
    }

    @Override
    public double area() {
        // TODO : Please implement this method
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Rectangle { w: %.2f, h: %.2f }", width, height);
    }
}
