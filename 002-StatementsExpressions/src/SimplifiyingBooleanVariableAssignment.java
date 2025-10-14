/**
 * @author Onder Sahin
 */
public class SimplifiyingBooleanVariableAssignment {

    public static void main(String[] args) {

        int number = 0;
        /*
        DON'T DO THIS
        boolean even;
       if(number % 2 == 0)
            even = true;
       else
            even = false;
        */

        boolean even = number % 2 == 0;
    }
}
