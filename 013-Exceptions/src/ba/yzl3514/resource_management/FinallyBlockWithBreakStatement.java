package ba.yzl3514.resource_management;

import ba.yzl3514.util.Exceptions;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FinallyBlockWithBreakStatement {


    public static void main(String[] args) {

        System.out.println("thread is started...");

        while(true) {
            try {
                System.out.println("trying...");
                Exceptions.throwCheckedException();
                break;
            } catch (Exception e) {
                System.out.println("Exception Handled");
                Exceptions.throwUncheckedException();
                return;
            } finally {
                System.out.println("Finally block !");
            }
        }

        //System.out.println("thread is continue...");

    }
}
