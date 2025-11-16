package ba.yzl3514.resource_management;

import java.io.IOException;
import java.util.Random;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FinallyBlockWithUnhandledException {

    public static void main(String[] args) {

        System.out.println("Main thread is started...");
        try{
            System.out.println("try block");
            doSomething();
        }catch (IOException e){
            System.out.println("catch block");
        }finally {
            System.out.println("Finally Block !");
        }


        System.out.println("main thread is continue...");
    }


    public static void doSomething() throws IOException{
        Random random = new Random();
        boolean b = random.nextBoolean();
        if(b) throw new IOException();
        throw new RuntimeException();
    }
}
