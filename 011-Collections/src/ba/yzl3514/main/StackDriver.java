package ba.yzl3514.main;

import ba.yzl3514.domain.MyStack;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class StackDriver {

    public static void main(String[] args) {


        MyStack<Integer> integerStack = new MyStack<>();
        System.out.println(integerStack);

        integerStack.push(309);
        integerStack.push(400);

        System.out.println(integerStack);

        System.out.println(integerStack.pop());
        System.out.println(integerStack);
        System.out.println(integerStack.pop());
        System.out.println(integerStack);

        System.out.println(integerStack.pop());

    }
}
