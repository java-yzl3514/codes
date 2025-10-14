/**
 * @author Onder Sahin
 */
public class DanglingElse {

    public static void main(String[] args) {
        int i = 2, j = 3, k = 4;


        if(i > j)
            if(i > k)
                System.out.println("A");
        else System.out.println("C");
        else System.out.println("B");


    }
}
