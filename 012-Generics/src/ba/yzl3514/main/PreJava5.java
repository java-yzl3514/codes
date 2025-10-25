package ba.yzl3514.main;

import ba.yzl3514.domain.Car;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class PreJava5 {

    public static void main(String[] args) {

        ArrayList numbers = new ArrayList(); // Raw Use


        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        //System.out.println(numbers);

        //....

        addMessageToList(numbers);

        //System.out.println(numbers);

        addCarToList(numbers);

        //System.out.println(numbers);


        doProcessOnList(numbers);

    }

    public static void addMessageToList(ArrayList list) {
        list.add("Message");
    }

    public static void addCarToList(ArrayList list) {
        list.add(new Car());
    }


    public static void doProcessOnList(List list) {
        for (int i = 0; i < list.size(); i++) {
            Object item = list.get(i);
            if (item instanceof Integer) {
                System.out.println(((Integer) item).intValue() * 2);
            }
        }
    }

    public static void doProcessOnList(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i] * 2);
        }
    }


}
