package ba.yzl3514.main;

import java.util.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class AddingGroupOfObjects {

    public static void main(String[] args) {

        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        collection.add(6);

        Integer[] more = {7, 8, 9};

        collection.addAll(Arrays.asList(more));

        System.out.println(collection);

        Collections.addAll(collection, 10, 11, 12, 13);

        System.out.println(collection);

        Collections.addAll(collection,more);
        System.out.println(collection);
    }
}
