package ba.yzl3514.main;

import ba.yzl3514.domain.ModernStack;
import ba.yzl3514.domain.PreJava6Stack;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class JavaStack {

    public static void main(String[] args) {

        // 1.0 java.util.Stack
        //java.util.Stack // Old-Way / Kullanılmamalı


        ModernStack<Integer> modernStack = new ModernStack<>();
        modernStack.push(23);
        modernStack.push(100);
        System.out.println(modernStack);

        PreJava6Stack<Integer> preJava6Stack = new PreJava6Stack<>();
        preJava6Stack.push(230);
        preJava6Stack.push(1000);
        System.out.println(preJava6Stack);

    }
}
