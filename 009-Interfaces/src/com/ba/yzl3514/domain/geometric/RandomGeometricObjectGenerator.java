package com.ba.yzl3514.domain.geometric;

import java.util.Random;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomGeometricObjectGenerator {

    private Random random;

    public RandomGeometricObjectGenerator() {
        random = new Random();
    }

    public GeometricObject next(){
        return switch (random.nextInt(3)){
            case 0 -> new Circle();
            case 1 -> new Rectangle();
            case 2 -> new Square();
            default -> null;
        };
    }

}
