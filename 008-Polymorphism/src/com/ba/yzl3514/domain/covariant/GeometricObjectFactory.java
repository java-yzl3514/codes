package com.ba.yzl3514.domain.covariant;

import com.ba.yzl3514.domain.geometric.GeometricObject;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class GeometricObjectFactory {

    public GeometricObject createGeometricObject(){
        System.out.println("GeometricObjectFactory.createGeometricObject()");
        //...;
        return new GeometricObject();
    }
}
