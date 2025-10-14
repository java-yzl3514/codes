package com.ba.yzl3514.super_keyword;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Derived extends Base{

    public Derived(int data){
        super(convertToString(data));
        System.out.println("Derived ctor finished.");
    }

    private static String convertToString(int data){
        System.out.println("... Generating data for super ctor...");
        // return "" + data;
        return String.valueOf(data);
    }
}
