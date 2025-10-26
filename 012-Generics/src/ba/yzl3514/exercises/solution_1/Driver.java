package ba.yzl3514.exercises.solution_1;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        LinkedStack<Integer> stack = new LinkedStack<Integer>();


        for(int i = 0; i < 2; i++){
            stack.push(i);
        }

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        stack.push(null);

        System.out.println(stack);

        System.out.println(stack.pop());

        if(stack.isEmpty()){
            // Tell, Don't Ask !
        }
    }
}
