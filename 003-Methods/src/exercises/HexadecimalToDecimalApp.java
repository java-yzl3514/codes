package exercises;

/**
 * @author Onder Sahin
 */
public class HexadecimalToDecimalApp {

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Please enter a hex integer : ");
        final int UNEXPECTED_VALUE = -1;
        String hexString = input.nextLine();
        //int hexValue  = input.nextInt(16);
        int decimalValue = convertHexToDecimal(hexString);
        if (decimalValue == UNEXPECTED_VALUE) {
            System.out.printf("The value %s is not legal hex value! Please try again.", hexString);
        } else {
            System.out.println("Decimal value is : " + decimalValue);
        }
    }

    public static int convertHexToDecimal(String hexString) {
        int decimalValue = 0;
        final int UNEXPECTED_VALUE = -1;
        for (int i = 0; i < hexString.length(); i++) {
            char hexChar = hexString.charAt(i);
            int hexToDecimalValue;
            if ((hexToDecimalValue = digitHexToDecimal(hexChar)) == UNEXPECTED_VALUE)
                return UNEXPECTED_VALUE;
            decimalValue = decimalValue * 16 + hexToDecimalValue;
        }
        return decimalValue;
    }

    public static int digitCharToDecimal(char digitChar) {
        final int NOT_DIGIT = -1;
        if (digitChar < '0' || digitChar > '9') return NOT_DIGIT;
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
