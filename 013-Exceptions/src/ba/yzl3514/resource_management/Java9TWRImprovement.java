package ba.yzl3514.resource_management;

import java.io.BufferedReader;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Java9TWRImprovement {

    public static void main(String[] args) {




    }


    public static void process(BufferedReader reader){
        // Resource References
        // COMPILE-TIME ERROR in Java 7 / 8
        /*
        try(reader){


        }catch (Exception e){

        }

         */
    }


    // JEP 213 :  https://openjdk.org/jeps/213
    public static void processWithJava9(BufferedReader reader, BufferedReader reader2){

        try(reader; reader2){

        }catch (Exception e){

        }
    }

}
