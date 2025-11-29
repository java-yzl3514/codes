package ba.yzl3514.main;

import ba.yzl3514.domain.IntFunction;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
class FactorialFunction implements IntFunction {
    @Override
    public int call(int arg) {
        if (arg == 0) return 1;
        return arg * call(arg - 1);
    }
}

public class RecursiveFactorial {
    private static IntFunction function;

    public static void main(String[] args) {
        function = n -> n == 0 ? 1 : n * function.call(n - 1);
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%d! = %d%n",i, function.call(i));
        }
    }
}
