package ba.yzl3514.resource_management;

import ba.yzl3514.resource_management.domain.MyResource;
import ba.yzl3514.util.Exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 *
 *
 * @author Onder Sahin
 * @see MyResource
 */
public class CustomResourceWithTWR {

    public static void main(String[] args) {

        //....
        try (MyResource myResource = new MyResource()) {
            System.out.println("trying...");
            //Exceptions.throwIOException();
            return;
        } catch (Exception e) {
            System.out.println("handler is running...");
        } finally {
            System.out.println("Finally");
        }

        System.out.println("continue...");
    }
}
