/**
 * @author Onder Sahin
 */
public class ReturnStatement {

    public static void main(String[] args) {
        int value =  100;
        if(value == 400)
            return;


        System.out.println("continue flow");

        return;
    }


    public static int add(int a, int b){
        /* 1:
        int result = a + b;
        return result;
        */

        // 2:
        return a + b;
    }
}
