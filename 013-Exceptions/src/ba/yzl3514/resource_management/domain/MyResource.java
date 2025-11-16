package ba.yzl3514.resource_management.domain;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class MyResource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("MyResource : Closing....");
    }
}
