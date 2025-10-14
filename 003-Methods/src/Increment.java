/**
 * @author Onder Sahin
 */
public class Increment {

    public static void main(String[] args) {

        int value = 1;
        System.out.println("Before the call, value is " + value);
        increment(value);
        System.out.println("After the call, value is " + value);

    }


    public static void increment(int value){
        value++;
        System.out.println("value inside the method is " + value);
    }

}
