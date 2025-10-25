package ba.yzl3514.main;

import ba.yzl3514.domain.DynamicArray;

import java.util.ArrayList;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        DynamicArray cart = new DynamicArray(3);
        cart.add("Water");
        cart.add("Apple");
        cart.add("Milk");
        cart.add("Soap");

        System.out.println(cart);

        cart.add(3);



        ArrayList list = new ArrayList();
        list.add("Water");
        list.add("Apple");
        list.add("Milk");
        list.add("Soap");
        System.out.println(list);

        list.add(3);
    }
}
