package ba.yzl3514.domain.nested;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Outer {

     private int nonStaticField;
     private static String outerStaticField = "Outer Static Field";

     public static class Nested {
        public void display(){

            // System.out.println(nonStaticField);
            System.out.println(outerStaticField);
        }
    }
}
