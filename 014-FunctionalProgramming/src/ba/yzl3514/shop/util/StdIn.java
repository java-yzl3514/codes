package ba.yzl3514.shop.util;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public final class StdIn{

    private static final Logger logger = Logger.getLogger(StdIn.class.getName());
    private static final Scanner keyboard;

    static {
        keyboard = new Scanner(System.in);
    }

    public static String read(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return keyboard.nextLine();
            } catch (Exception e) {
                logger.severe(e.getMessage());
            }
        }
    }

    public static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(read(prompt));
            } catch (Exception e) {
                logger.severe(e.getMessage());
            }
        }
    }


}
