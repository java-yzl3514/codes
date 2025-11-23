package ba.yzl3514.main;

import java.util.*;

/**
 *
 *  TreeSet : red-black tree
 *  HashSet : hash fonksiyonu kullanır, sıralamanın garantisi yoktur.
 *  LinkedHashSet : hızlı arama için hashing kullanır fakat öğeleri eklenme sırasına göre tutuyormuş olarak
 *  görünür(linked list ile)
 *
 * @author Onder Sahin
 *
 */
public class Sets {

    public static void main(String[] args) {

        Random random = new Random();
        Set<Integer> numbers = new LinkedHashSet<>();
        for(int i = 0; i< 10_000; i++){
            numbers.add(random.nextInt(20));
        }
        System.out.println(numbers);
    }
}
