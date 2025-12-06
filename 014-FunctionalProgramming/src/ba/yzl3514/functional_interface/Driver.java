package ba.yzl3514.functional_interface;

import java.util.Comparator;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */


public class Driver {

    public String goodBye(String arg){
        return "Goodbye, " + arg;
    }


    public static void main(String[] args) {

        Driver driver = new Driver();

        driver.goodBye("");

        // Target Types
        MyFunctionalInterface functionalInterface = driver::goodBye;
        MyFunctionalInterfaceNoAnn interfaceNoAnn = driver::goodBye;

        MyFunctionalInterface fl = s -> "Goodbye, " + s;
        MyFunctionalInterfaceNoAnn fnal = s -> "Goodbye, " + s;

        //MyFunctionalInterface myFunctionalInterface = driver;

        Comparable<Integer> integer = 3;

        integer.equals(34);

        Object o = fl;


    }
}
