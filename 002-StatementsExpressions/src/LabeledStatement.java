/**
 * @author Onder Sahin
 */
public class LabeledStatement {
    public static void main(String[] args) {


        A:
        for (int i = 0; i < 10; i++) {
            if(i == 3){
                break A;
            }
        }

    }
}
