package com.ba.yzl3514.domain.geometric;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
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

    /*
        Prints the string representation of the object
     */
   /*
   // Aşağıdaki metot override kurallarının hangisini çiğnemiştir ?

   protected void print() {
        System.out.printf("Circle { radius: %.2f }%n", radius);
    }
    */
    @Override
    public void print(){
        System.out.printf("Circle { radius: %.2f }%n", radius);
    }

    @Override
    public void bar(){
        System.out.println("Circle.bar()");
    }
}
