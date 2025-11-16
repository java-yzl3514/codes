package ba.yzl3514.exception_specification;


/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DriverTask {

    public static void main(String[] args) {

        //WriteConsoleTask writeConsoleTask = new WriteConsoleTask("Secret Message");
        //writeConsoleTask.run();

        Task writeConsoleTask = new WriteConsoleTask("Secret Message");
        try {
            writeConsoleTask.run();
        }catch (Exception e){ // catching "any" exception
            //log
        }

    }
}
