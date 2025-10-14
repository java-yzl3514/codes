/**
 * @author Onder Sahin
 */
public class HelloWhile {

    public static void main(String[] args) {


        java.util.Scanner keyboard = new java.util.Scanner(System.in);

        System.out.println("Enter an integer to count : ");
        int n = keyboard.nextInt();

        while(n-- > 0)
            System.out.printf("%d ", n);

        System.out.printf("%nAfter Loop, n = %d%n", n);
        System.out.println("Tekrar Yapıyor musunuz ?????");



    }
}
