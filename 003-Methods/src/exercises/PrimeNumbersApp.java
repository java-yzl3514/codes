package exercises;

/**
 * @author Onder Sahin
 */
public class PrimeNumbersApp {

    public static void main(String[] args) {
        run(args);
    }

    public static void run(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Please enter an integer value as n to print first n prime numbers : ");
        printFirstNPrimeNumbers(input.nextInt());
    }

    public static void printFirstNPrimeNumbers(int n) {
        final int NUMBER_OF_PRIME_NUMBERS_PER_LINE = 20;
        int count = 0;
        int testNumber = 2;
        while (count < n) {
            if (isPrime(testNumber)) {
                count++;
                //if (count % 20 == 0) {
                if (count % NUMBER_OF_PRIME_NUMBERS_PER_LINE == 0) {
                    System.out.printf("%-4s\n", testNumber);
                } else {
                    System.out.printf("%-4s ", testNumber);
                }
            }
            testNumber++;
        }

    }

    public static boolean isPrime(long testNumber) {
        if (testNumber <= 1) {
            return false;
        }
        for (long d = 2; d < testNumber; d++) {
            if (testNumber % d == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeV2(long testNumber) {
        if (testNumber <= 1) {
            return false;
        }
        for (long d = 2; d <= testNumber / 2; d++) {
            if (testNumber % d == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrimeV3(long testNumber){

        if(testNumber <= 1){
            return false;
        }

        if(testNumber % 2 == 0) {
            return testNumber == 2;
        }

        if(testNumber % 3 == 0){
            return testNumber == 3;
        }

        if(testNumber % 5 == 0){
            return testNumber == 5;
        }

        if(testNumber % 7 == 0){
            return testNumber == 7;
        }

        // for(long d = 11; d <= Math.sqrt(testNumber); d += 2){  (?) (!)
        for(long d = 11; d * d <= testNumber; d += 2){
            if(testNumber % d == 0){
                return false;
            }
        }

        return true;
    }

}
