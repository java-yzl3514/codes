package com.ba.yzl3514.domain.geometric;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class GeometricObjects {


    public static void print(GeometricObject geometricObject){

        if(geometricObject instanceof Rectangle rectangle){
            rectangle.print();
        }else if(geometricObject instanceof Square square){
            square.print();
        }else if(geometricObject instanceof Circle circle){
            circle.print();
        }
    }

}
