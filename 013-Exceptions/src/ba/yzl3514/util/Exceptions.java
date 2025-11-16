package ba.yzl3514.util;

import java.io.IOException;
import java.util.Random;

/**
 * This class is used for exception simulation utility.
 *
 * @author Onder Sahin
 *
 */
public class Exceptions {


    /**
     *
     */
    public static void throwRuntimeException() {
        throw new RuntimeException();
    }

    /**
     *
     * @throws IOException
     */
    public static void throwIOException() throws IOException {
        throw new IOException();
    }


    /**
     *
     */
    public static void throwRandomException() throws Exception {
        Random random = new Random();
        if (random.nextBoolean())
            throwRuntimeException();
        throwIOException();
    }

    /**
     *
     */
    public static void throwCheckedException() throws Exception {
        throwIOException();
    }

    public static void throwUncheckedException() {
        throwRuntimeException();
    }

    public static void throwNoSuchFieldException() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

}
