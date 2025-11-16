package ba.yzl3514.resource_management;

import ba.yzl3514.util.Exceptions;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class HelloFinally {

    public static void main(String[] args) {

        System.out.println("Main thread is started...");
          try{
              System.out.println("try block");
          }catch (Exception e){
              System.out.println("catch block");
          }finally {
              System.out.println("Finally Block !");
              try {
                  Exceptions.throwIOException();
              }catch (Exception e){
                  // ...

              }
          }


        System.out.println("main thread is continue...");
    }
}
