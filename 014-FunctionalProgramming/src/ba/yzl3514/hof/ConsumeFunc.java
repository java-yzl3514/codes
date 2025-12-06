package ba.yzl3514.hof;

import java.util.function.Function;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
class Foo{}
class Bar{}

public class ConsumeFunc {

    //hof
    public static Bar consume(Function<Foo, Bar> fooToBar){
            return fooToBar.apply(new Foo());
    }

    public static void main(String[] args) {
        Bar bar  = consume(foo -> new Bar());
    }


}
