/**
 * @author Onder Sahin
 */
public class ContinueStatement {
    public static void main(String[] args) {

        MAIN_LOOP:
        for(int i = 0; i < 10; i++){
            System.out.printf("i : %d%n",i);
            for(int k = 0; k < 10; k ++){
                if(k % 2 == 0){
                    continue MAIN_LOOP;
                }
                System.out.printf("k : %d%n",k);
            }
        }

    }
}
