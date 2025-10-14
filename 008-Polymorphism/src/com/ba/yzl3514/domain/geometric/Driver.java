package com.ba.yzl3514.domain.geometric;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {


        Rectangle rectangle = new Rectangle(10, 8);
        GeometricObjects.print(rectangle); // Upcasting


        Circle circle = new Circle(10);
        GeometricObjects.print(circle); // Upcasting

        Square square = new Square(10);
        GeometricObjects.print(square); // Upcasting


        circle.bar();
        rectangle.bar();


    }


}
