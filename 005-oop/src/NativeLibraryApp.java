import java.sql.DriverManager;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class NativeLibraryApp {

    static {
        try{
            System.loadLibrary("opencv_java");
        }catch (UnsatisfiedLinkError e){
            System.out.println("Native Library can not be loaded");
            System.exit(1);
        }

    }


    //...
}
