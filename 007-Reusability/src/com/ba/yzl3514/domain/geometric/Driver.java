package com.ba.yzl3514.domain.geometric;

import com.ba.yzl3514.domain.inheritance.C;

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
        //rectangle.printDetail();
        GeometricObjects.print(rectangle); // Upcasting

        //...

        Circle circle = new Circle(10);
        //circle.display();
        GeometricObjects.print(circle); // Upcasting

        //
        Square square = new Square(10);
        //square.print();
        GeometricObjects.print(square); // Upcasting


        GeometricObject geometricObject = square; // implicitly casting (upcasting)
        geometricObject = new Circle(3); // implicitly casting (upcasting)

        Circle circle1 = (Circle) geometricObject;


        Object o = Integer.valueOf(100);
        if(o instanceof String){
            String str =  (String)o;
        }

    }


}
