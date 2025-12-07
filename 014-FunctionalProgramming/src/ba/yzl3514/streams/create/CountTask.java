package ba.yzl3514.streams.create;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
// public class CountTask implements Runnable {
public class CountTask {

    private int i;

    public void run() {
        System.out.println(i++);
    }
}
