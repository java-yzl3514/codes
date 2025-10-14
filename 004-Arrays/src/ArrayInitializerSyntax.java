/**
 * @author Onder Sahin
 */
public class ArrayInitializerSyntax {

    public static void main(String[] args) {


        int[] numbers = {1,2,3,4,5,6,};

        int[] numbers2 = new int[]{1,2,3,34,6,7};

        int[] numbers3;

       // number3 = {1,2,3,4,5}; // COMPILE-TIME ERROR


        foo(new int[]{1,2,3,4,5,}); // Bu notasyon argüman geçilmesi sırasında kullanılabilir.


    }


    public static void foo(int[] arr){

    }
}
