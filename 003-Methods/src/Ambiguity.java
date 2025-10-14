/**
 * @author Onder Sahin
 */
public class Ambiguity {


    public static void calculate(int a, long b){
        System.out.println("calculate(int,long)");
    }

    public static void calculate(long a, int b){
        System.out.println("calculate(long, int)");
    }

}
