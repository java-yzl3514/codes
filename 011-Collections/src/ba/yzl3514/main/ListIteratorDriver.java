package ba.yzl3514.main;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ListIteratorDriver {

    public static void main(String[] args) {


        List<Integer> numbers = new LinkedList<>(Arrays.asList(1,2,3,4,5,6));
        ListIterator<Integer> listIterator = numbers.listIterator();

        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }

        System.out.println("======");
        while(listIterator.hasPrevious()){
            Integer previous = listIterator.previous();
            listIterator.set(previous * 2);
            System.out.println(previous);
        }

        System.out.println(numbers);

    }
}
