/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class StaticInitialization {
    public static int value;

    static {
        value = 34;
        System.out.println("StaticInitialization.static.block");
    }

    public static long coefficient = 45L;
    static {
        coefficient = 45;
        System.out.println("StaticInitialization.static.block.3");
    }

    static {
        System.out.println("StaticInitialization.static.block.2");
    }

    public static void foo(){
        System.out.println("StaticInitialization.foo()");
    }

    public StaticInitialization(){
        System.out.println("StaticInitialization.ctor");
    }

}
