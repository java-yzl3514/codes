package ba.yzl3514.exercises.solution_2;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is a RandomList
 *
 * @author Onder Sahin
 */
public class RandomListAsComposition<T> {
    private ArrayList<T> list = new ArrayList<T>();
    private Random random = new Random();


    public void add(T item){
        list.add(item);
    }

    public T select(){
        return list.get(random.nextInt(list.size()));
    }
}
