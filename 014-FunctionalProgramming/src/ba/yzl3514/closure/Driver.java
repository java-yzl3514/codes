package ba.yzl3514.closure;

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
public class Driver {

    public static void main(String[] args) {


        ClosureA a = new ClosureA();
        ClosureA b = new ClosureA();

        IntSupplier supplier = a.foo(4);

        System.out.println(supplier);
        System.out.println(supplier.getAsInt());

        IntSupplier supplier2 = a.foo(4);
        System.out.println(supplier2);
        System.out.println(supplier.getAsInt());

        System.out.println(a.i);

        IntSupplier supplier1 = b.foo(50);
        System.out.println(supplier1);
        System.out.println(supplier1.getAsInt());


        System.out.println(a.bar(50).getAsInt());

        System.out.println(a.bar(50).getAsInt());

        System.out.println("-----------------");
        Supplier<List<Integer>> supp = a.baz();
        List<Integer> integerList = supp.get();
        System.out.println(integerList); // 1
        integerList.add(200);
        System.out.println(integerList); // 2

        Supplier<List<Integer>> supp2 = a.baz();
        System.out.println(supp2.get());

    }
}
