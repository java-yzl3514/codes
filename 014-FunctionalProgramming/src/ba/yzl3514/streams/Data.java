package ba.yzl3514.streams;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Data {
    private int i;

    public Data(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    @Override
    public String toString() {
        return "Data(" + i + ")";
    }
}
