package ba.yzl3514.resource_management;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FinallyBlockWithException {

    public static void main(String[] args) {

        System.out.println("Main thread is started...");

        try{
            System.out.println("try block");
            throw new Exception();
        }catch (Exception e){
            System.out.println("catch block");
        }finally {
            System.out.println("Finally Block !");
        }

        System.out.println("main thread is continue...");
    }
}
