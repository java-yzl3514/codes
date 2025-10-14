/**
 * @author Onder Sahin
 */
/*
    Aşağıdaki örnekte JavaSE nın binary gösterim için sunduğu Integer sınıfının toBinaryString metodunun
    kullanımı da gösterilmiştir. Burada amaç hazır olan metotları tanıtmak olduğu kadar algoritmik becerileri
    de geliştirmektir.

 */
public class DecimalToBinaryRepresentationApp {
    public static void main(String[] args) {

        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        System.out.println("Please enter an decimal integer to binary representation : ");
        int val = keyboard.nextInt();
        if(val == 0){
            System.out.println(val);
        }else{

            long reversedBinary = 0;
            int temp = val;
            int digitMultiplier = 1;

            while (temp > 0){
                int remainder = temp % 2;
                reversedBinary = reversedBinary + (remainder * digitMultiplier);
                temp = temp / 2;
                digitMultiplier = digitMultiplier * 10;
            }

            System.out.printf("%d is in binary %d%n", val, reversedBinary);
            System.out.printf("%d is in binary %s%n", val, Integer.toBinaryString(val));

        }


        keyboard.close(); // Sistem kaynaklarının doğru kullanımı için
    }
}
