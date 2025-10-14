package com.ba.yzl3514.domain.geometric;

/**
 * @author Onder Sahin
 *
 */
// Concrete Class
public class Circle extends GeometricObject {

    private double radius;

    public Circle(){
        this(1);
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    protected void foo(){
        getColor();
    }

    @Override
    public void draw() {
        System.out.println("Circle drawing....");
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void bar(){
        System.out.println("Circle.bar()");
    }

    @Override
    public String toString() {
        return String.format("Circle { radius: %.2f }%n", radius);
    }
}
