/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class NonStaticInitialization {

    public int value;
    public boolean flag;

    {
        System.out.println("Non-static.initialization.block.1");
    }

    {
        System.out.println("Non-static.initialization.block.2");
        foo();
    }

    public static void foo(){

    }

    public NonStaticInitialization(){

    }

    public NonStaticInitialization(int value){

    }

}
