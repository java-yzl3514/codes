/**
 * @author Onder Sahin
 */
public class Labels {
    public static void main(String[] args) {

        Labels:
        break Labels;

        {

        }

        A:
        {
            System.out.println("Test");
            break A;
        }
        int b = 9;

        A:
        b++;

        LABELS:
        {
            int a = 900;
            if (a == 1000) {
                break LABELS;
            }

            System.out.println("Test");

        }

        LABELS:
        break LABELS;
    }
}
