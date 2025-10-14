import java.lang.reflect.Constructor;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ClassLiteralApp {
    public static void main(String[] args) {

        Class beeClass = Bee.class;

        Class<Integer> intClass = int.class;
        Class intClass2 = int.class;
        Class intArrayClass = int[].class;
        Class intArray2Dimension = int[][].class;

        Class<Integer> wrapperIntClass = Integer.class;
        Class voidClass  = void.class; // special type
        Class wrapperVoidClass = Void.class;

        if(intClass == intClass2){
            System.out.println("yes same");
        }

        if(intClass == wrapperIntClass){
            System.out.println("primitive and wrapper are same");
        }

        // Class ballClass = Ball.class;
        // Class.forName("com.paket.ClassName");



    }
}
