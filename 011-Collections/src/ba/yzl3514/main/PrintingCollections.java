package ba.yzl3514.main;

import ba.yzl3514.domain.MyType;

import java.util.*;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class PrintingCollections {

    public static void main(String[] args) {

        //MyType myType = new MyType();
        //System.out.println(myType);

        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(collection);

        Map<Integer, String> cities = new HashMap<>();
        cities.put(34, "Istanbul");
        cities.put(6, "Ankara");
        cities.put(35, "İzmir");

        System.out.println(cities);

        //
        String s = cities.get(34);
        System.out.println(s);
    }
}
