package com.ba.yzl3514.domain.geometric;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Square extends GeometricObject {

    private double sideLength;

    public Square() {
        this(1);
    }

    public Square(int sideLength) {
        this((double) sideLength);
    }

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    @Override
    public void print() {
        System.out.printf("Square { sideLength: %.2f }%n", sideLength);
    }
}
