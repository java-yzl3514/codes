package exercises;

/**
 * @author Onder Sahin
 */
public class HexadecimalToDecimalAppWithExceptions {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Please enter a hex integer : ");
        String hexString = input.nextLine();
        System.out.println("Decimal value is : " + convertHexToDecimal(hexString));
    }

    public static int convertHexToDecimal(String hexString) {
        int decimalValue = 0;
        for (int i = 0; i < hexString.length(); i++) {
            char hexChar = hexString.charAt(i);
            decimalValue = decimalValue * 16 + digitHexToDecimal(hexChar);
        }
        return decimalValue;
    }

    public static int digitCharToDecimal(char digitChar) {
        if (digitChar < '0' || digitChar > '9')
            throw new RuntimeException(String.format("The value %s is not legal digit value!", digitChar));
        return digitChar - '0';
    }

    public static int digitHexToDecimal(char hexChar) {
        if (hexChar >= 'A' && hexChar <= 'F')
            return 10 + hexChar - 'A';
        if (hexChar >= 'a' && hexChar <= 'f')
            return 10 + hexChar - 'a';
        return digitCharToDecimal(hexChar);
    }
}
