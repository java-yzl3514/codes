package ba.yzl3514.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Lists {


    public static void main(String[] args) {


        List<Integer> integers = new LinkedList<>(Arrays.asList(1, 2, 3, 43, 45, 56));

        System.out.println(integers);
        integers.set(2, 800); // O(1)

        System.out.println(integers);

        integers.add(2, 3);
        System.out.println(integers);

    }
}
