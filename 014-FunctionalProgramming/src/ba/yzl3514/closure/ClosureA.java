package ba.yzl3514.closure;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ClosureA {

    int i;


    public IntSupplier foo(int a) {
        return () -> a + i++;
    }


    public IntSupplier bar(int x) {
        int i = 100;
        i++;
        x++;
        int a = i;
        int b = x;
        return () -> a + b;
    }

    public IntSupplier buzz(int x) {
        int i = 1000;
        i++;
        int finalI = i;
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + finalI;
            }
        };
    }




    /*
    public IntSupplier tar(int x) {
        Integer i = 100;
        i = i + 1;
        return () -> x + i;
    }
     */

    public Supplier<List<Integer>> baz() {
            List<Integer> list = new ArrayList<>();
            list.add(100);
            // list = new ArrayList<>();
            return () -> list;
    }


}
