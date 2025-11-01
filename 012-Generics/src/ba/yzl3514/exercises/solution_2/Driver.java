package ba.yzl3514.exercises.solution_2;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {
    public static void main(String[] args) {


         // RandomListAsInheritance<Integer> integers = new RandomListAsInheritance<Integer>();
        //

        RandomListAsComposition<Integer> list = new RandomListAsComposition<Integer>();

        for(int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list.select());
        System.out.println(list.select());

    }
}
