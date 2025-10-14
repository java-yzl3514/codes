/**
 * @author Onder Sahin
 */
public class ConditionalOperators {
    public static void main(String[] args) {


        if(methodA() & methodB()){
            System.out.println("test");
        }

        if(methodA() && methodB()){
            System.out.println("test");
        }


    }

    public static boolean methodA() {
        System.out.println("methodA");
        return false;
    }

    public static boolean methodB(){
        System.out.println("methodB");
        return true;
    }
}
