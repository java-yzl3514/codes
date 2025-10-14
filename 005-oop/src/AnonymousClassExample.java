/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class AnonymousClassExample {


    public static void main(String[] args) {

        java.util.List<String> list = new java.util.ArrayList<>(){
            {
                add("Item 1");
                add("Item 2");
            }

        };

        Sample sample = new Sample(){
            {
                System.out.println("Sample Instance Created.");
            }
        };
    }
}
