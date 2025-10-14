package model;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Circle {

    private int radius;
    private double area;

    public Circle(){
        this(1);
    }

    public Circle(int radius){
        if(radius < 0){
            throw new IllegalArgumentException("Radius must not be negative !");
        }
        this.radius = radius;
        area = Math.PI * radius * radius;
    }

    public void setRadius(int radius){
        if(radius < 0){
            throw new IllegalArgumentException("Radius must not be negative !");
        }
        this.radius = radius;
        area = Math.PI * radius * radius;
    }

}
