package ba.yzl3514.domain.exercises.solution_1;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Main {

    public static void main(String[] args) {

        Sequence sequence = new Sequence(100);
        for (int i = 0; i < 10; i++)
            sequence.add(i);

        System.out.println(sequence);

        Selector selector = sequence.selector();
        while(!selector.end()){

            System.out.print(selector.current() + " ");
            selector.next();
        }

    }

}
