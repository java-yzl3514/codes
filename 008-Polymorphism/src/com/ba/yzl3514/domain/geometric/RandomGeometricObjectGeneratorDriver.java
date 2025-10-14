package com.ba.yzl3514.domain.geometric;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomGeometricObjectGeneratorDriver {
    public static void main(String[] args) {


        RandomGeometricObjectGenerator  geometricObjectGenerator = new RandomGeometricObjectGenerator();
        GeometricObject geometricObject  = geometricObjectGenerator.next();
        geometricObject.print();
    }
}
