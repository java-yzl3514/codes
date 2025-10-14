package ba.yzl3514.domain.inner;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Outer {

    private String outerNonStaticField  = "Outer non-static field";

    public class Inner{

        private static final int VALUE  = 190;

        private static String staticField;

         static {}

        public void display(){ }

        public static void foo(){

        }
    }



    public static record InnerRecord(int x){

        public static void foo(){

        }
    }
}
