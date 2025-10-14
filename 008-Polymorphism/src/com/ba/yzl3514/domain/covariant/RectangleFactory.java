package com.ba.yzl3514.domain.covariant;

import com.ba.yzl3514.domain.geometric.Rectangle;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RectangleFactory extends GeometricObjectFactory{

    /*
    public GeometricObject createGeometricObject(){
        System.out.println("RectangleFactory.createGeometricObject()");
        return new Rectangle(10, 4);
    }
     */

    @Override
    public Rectangle createGeometricObject(){
        System.out.println("RectangleFactory.createGeometricObject()");
        return new Rectangle(10, 4);
    }

}
