package ba.yzl3514.erasure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<String>();
        List<Integer> integerList = new ArrayList<Integer>();

        System.out.println(stringList.getClass() == integerList.getClass());

    }
}
