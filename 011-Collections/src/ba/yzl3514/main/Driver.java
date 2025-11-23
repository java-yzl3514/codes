package ba.yzl3514.main;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        Collection<Integer> collection = new ArrayList<>();

        addIntegersToCollection(collection);

        for(Integer i : collection){
            System.out.println(i);
        }


    }

    //public static void addIntegersToCollection(Collection<? super Integer> collection) {
    public static void addIntegersToCollection(Collection<Integer> collection) {
        for(int i = 0; i < 10; i++) {
            collection.add(i); // Autoboxing
        }
    }
}
