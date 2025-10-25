package ba.yzl3514.main;

import ba.yzl3514.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Hello Generics !
 *
 * @author Onder Sahin
 *
 */
public class Java5Generics {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        //System.out.println(numbers);

        //....


        // numbers.add("String"); // COMPILE-TIME ERROR

        addMessageToList(numbers);

        //System.out.println(numbers);

        // addCarToList(numbers); // COMPILE-TIME ERROR

        //System.out.println(numbers);


        doProcessOnList(numbers);

    }


    public static void addMessageToList(ArrayList<Integer> list) {
        //list.add("Message"); // COMPILE-TIME ERROR
    }

    public static void addCarToList(ArrayList<Car> list) {
        list.add(new Car());
    }


    public static void doProcessOnList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) * 2);
        }
    }
}
