package ba.yzl3514.main;

import ba.yzl3514.domain.MyIterableClass;

import java.util.Iterator;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DriverMyIterable {

    public static void main(String[] args) {

        MyIterableClass myIterableClass = new MyIterableClass();

        /*
        for (Object o : myIterableClass) {
            System.out.println(o);
        }
        */

        Iterator<Integer> iterator =  myIterableClass.iterator();

        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }

    }
}
