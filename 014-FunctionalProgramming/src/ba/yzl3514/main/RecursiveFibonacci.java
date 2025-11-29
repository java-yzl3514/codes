package ba.yzl3514.main;

import ba.yzl3514.domain.IntFunction;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class RecursiveFibonacci {

    private IntFunction function;

    public RecursiveFibonacci(){
        function = (n) ->
                            n == 0 ? 0 :
                            n == 1 ? 1 :
                            function.call(n - 1) + function.call(n - 2);
    }

    public int fibonacci(int n){
        return function.call(n);
    }

    public static void main(String[] args) {

        RecursiveFibonacci recursiveFibonacci = new RecursiveFibonacci();
        for(int i = 0; i <= 10; i++){
            System.out.println(recursiveFibonacci.fibonacci(i));
        }
    }

}
