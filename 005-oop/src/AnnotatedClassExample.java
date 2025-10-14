/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class AnnotatedClassExample {

    public static void main(String[] args) {

        Class<OldAPI> oldAPIClass = OldAPI.class;

        if(oldAPIClass.isAnnotationPresent(Deprecated.class)){
            System.out.println("OldAPI class is deprecated !");
        }

    }
}
