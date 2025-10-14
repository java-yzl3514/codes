/**
 * @author Onder Sahin
 */
public class RandomNumberGenerate {
    public static void main(String[] args) {

        java.util.Random random = new java.util.Random();

        System.out.println("Generated Number : " + random.nextInt());
        System.out.println("Generated Number : " + random.nextInt(1000)); // [0-bound) // Integral Numbers
        System.out.println("Generated Number : " + random.nextInt(10, 30)); // JDK 17 - [origin-bound) Integral Numbers
        System.out.println("Generated Number : " + random.nextDouble()); // [0.0 - 1.0) Real Numbers
        // Lütfen diğer nextXXX metotlarını siz çağırıp kullanın ve çıktıları gözlemleyin



    }
}
