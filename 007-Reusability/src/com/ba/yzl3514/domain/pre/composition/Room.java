package com.ba.yzl3514.domain.pre.composition;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Room {
    private String name;
    private double area;

    public Room(String name, double area){
        this.name = name;
        this.area = area;
    }

    public void printInfo(){
        System.out.println(" -> Room : " + name + ", Area: " + area + "sqm");
    }
}
