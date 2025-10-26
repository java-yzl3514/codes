package ba.yzl3514.exercises.solution_0;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        TwoTuple<Integer, String> twoTuple = new TwoTuple<Integer, String>(34, "Istanbul");

        // twoTuple.a = 45; // COMPILE-TIME ERROR

        System.out.println(twoTuple);

        ThreeTuple<Integer, Integer, String> threeTuple = new ThreeTuple<Integer, Integer, String>(1, 34, "Istanbul");
        System.out.println(threeTuple);

    }
}
