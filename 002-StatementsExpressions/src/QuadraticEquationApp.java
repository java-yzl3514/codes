/**
 * @author Onder Sahin
 */
public class QuadraticEquationApp {

    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter coefficients : ");

        double a = keyboard.nextDouble();
        double b = keyboard.nextDouble();
        double c = keyboard.nextDouble();


        double delta = b * b - 4 * a * c;

        if(delta > 0){
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.printf("x1 = %f, x2 = %f%n", x1, x2);
            //System.out.println("x1 = " + x1 + ", x2 = " + x2); // otherwise
        }else if(delta == 0){
            double x = -b / (2 * a);
            System.out.printf("x1 = x2 = %f%n", x);
        }else
            System.out.println("No real root !");

        keyboard.close(); // Sistem kaynaklarının doğru kullanımı için
    }


}
