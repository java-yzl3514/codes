/**
 * @author Onder Sahin
 */
public class BreakStatement {
    public static void main(String[] args) {

        A:
        break A;

        MAIN_LOOP:
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j < 5 ; j++) {
                if(i == 2 && j == 2){
                    break MAIN_LOOP;
                }
            }
        }


    }
}
