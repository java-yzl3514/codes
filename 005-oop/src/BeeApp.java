import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class BeeApp {

    public static void main(String[] args) {

        Class<Bee> beeClass = Bee.class;

        System.out.println("Bee class methods : ");
        Method[] methods = beeClass.getDeclaredMethods();

        for(int i = 0; i < methods.length; i++){
            System.out.println(methods[i].getName());
        }

    }
}
