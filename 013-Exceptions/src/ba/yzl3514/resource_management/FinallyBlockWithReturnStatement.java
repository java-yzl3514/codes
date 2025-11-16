package ba.yzl3514.resource_management;

import ba.yzl3514.util.Exceptions;

import java.util.SortedMap;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FinallyBlockWithReturnStatement {


    public static void main(String[] args) {


        System.out.println("thread is started...");

        try{
            System.out.println("trying...");
            Exceptions.throwRuntimeException();
            return;
        }catch (Exception e){
            System.out.println("Exception Handled");
            Exceptions.throwUncheckedException();
            return;
        }finally {
            System.out.println("Finally block !");
        }

        //System.out.println("thread is continue...");

    }
}
