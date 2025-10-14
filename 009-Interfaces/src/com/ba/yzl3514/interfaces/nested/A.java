package com.ba.yzl3514.interfaces.nested;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public interface A {

    public static interface B{

        public static interface C{



        }
    }

    public static class Test implements A{
        public static void main(String[] args) {

        }
    }
}
