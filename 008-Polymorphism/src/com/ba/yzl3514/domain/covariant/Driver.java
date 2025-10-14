package com.ba.yzl3514.domain.covariant;

import com.ba.yzl3514.domain.geometric.Rectangle;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        RectangleFactory factory = new RectangleFactory();
        Rectangle rectangle = factory.createGeometricObject();


        /*
        // Aşağıdaki satırı çalıştırınız, sonuçları gözlemleyiniz ve açıklayınız

        GeometricObjectFactory factory1 = new CircleFactory();
        Rectangle rectangle1 = (Rectangle) factory1.createGeometricObject();

         */

    }
}
