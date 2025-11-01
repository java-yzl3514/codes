package ba.yzl3514.exercises.solution_2;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is a RandomList
 *
 *
 * @author Onder Sahin
 *
 */
public class RandomListAsInheritance<T> extends ArrayList<T> {

    private Random random = new Random();

    public T select(){
        return get(random.nextInt(size()));
    }

}
