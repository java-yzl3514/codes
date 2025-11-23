package ba.yzl3514.domain;

import java.util.Iterator;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class MyIterableClass implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            private int count = 5;

            @Override
            public boolean hasNext() {
                System.out.println("Iterator.hasNext()");
                return count-- > 0;
            }

            @Override
            public Integer next() {
                System.out.println("Iterator.next()");
                return count;
            }
        };
    }
}
