package ba.yzl3514.exception_specification;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class WriteConsoleTask implements Task {

    private String message;

    public WriteConsoleTask(String message) {
        this.message = message;
    }

    @Override
    public void run() throws Exception{
        System.out.println(message);
    }
}
