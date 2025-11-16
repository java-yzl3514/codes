package ba.yzl3514.resource_management;

import ba.yzl3514.util.Exceptions;

/**
 *
 * !! ATTENTION  !!  : PITFALL !!!!
 *
 * @author Onder Sahin
 *
 */
public class TryFinallyBlocks {
    public static void main(String[] args) {

        System.out.println("thread is started...");

        try {
            try {
                System.out.println("trying...");
                Exceptions.throwNoSuchFieldException();
            } finally {
                System.out.println("Finally block !");
                Exceptions.throwCheckedException();
            }
        } catch (Exception e) {
            System.out.println("Outer handler...");
            e.printStackTrace(System.out);
        }
    }
}
