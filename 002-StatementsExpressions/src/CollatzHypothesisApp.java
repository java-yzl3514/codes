/**
 * @author Onder Sahin
 */
public class CollatzHypothesisApp {

    public static void main(String[] args) {
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer to run Collatz Hypothesis : ");
        int val = keyboard.nextInt();
        int totalStepCount = 0;

        while(val != 1){
            if(val % 2 == 0){
                val = val / 2;
            }else{
                val = 3 * val + 1;
            }
            System.out.printf("Step for %d%n", val);
            totalStepCount++;
        }

        System.out.printf("Total step count = %d%n", totalStepCount);

        keyboard.close(); // Sistem kaynaklarının doğru kullanımı için
    }
}
