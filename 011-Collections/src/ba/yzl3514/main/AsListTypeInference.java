package ba.yzl3514.main;

import java.util.Arrays;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */

class Foo{}
class BarFoo extends Foo{}
class XBarFoo extends BarFoo{}
class YBarFoo extends BarFoo{}
class TarFoo extends Foo{}
class BazFoo extends Foo{}

public class AsListTypeInference {

    public static void main(String[] args) {

        List<Foo> fooList = Arrays.asList(new TarFoo(), new BazFoo(), new BarFoo(), new YBarFoo());
        //fooList.add(new XBarFoo());

        // explicit type argument
        for(Object o : Arrays.<Foo>asList(new TarFoo(), new BazFoo(), new BarFoo(), new YBarFoo())){
            System.out.println(o.getClass().getName());
        }

    }
}
