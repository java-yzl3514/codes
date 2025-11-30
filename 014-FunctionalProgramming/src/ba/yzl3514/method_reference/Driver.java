package ba.yzl3514.method_reference;

import ba.yzl3514.method_reference.domain.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {


    public static void main(String[] args) {

        //Object o = String::length;


        Function<String, Integer> f = String::length;

        System.out.println(f.apply("Hello"));

        f =  str -> Integer.parseInt(str);
        System.out.println(f.apply("4"));


        A a = new A();

       Function<A, Integer> ff =  A::foo;
       a.foo();

        System.out.println("===");

        String[] str = {
                "Hello",
                "Java",
                "Functional",
                "Programming"
        };

        List<String> strings = new ArrayList<>(Arrays.asList(str));

        strings.stream().filter(s -> s.length() < 5)
                .forEach(System.out::println);

    }


    public void foo(){

    }
}
