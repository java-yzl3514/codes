package ba.yzl3514.resource_management;


/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FinallyDoesNotExecuted {

    public static void main(String[] args) {


        System.out.println("Main thread is started...");
        try{
            System.out.println("try block");
            System.exit(1); // Stops the JVM!!!!
        }catch (Exception e){
            System.out.println("catch block");
        }finally {
            System.out.println("Finally Block !");
        }

        System.out.println("main thread is continue...");

    }
}
