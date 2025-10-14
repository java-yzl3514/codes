package ba.yzl3514.domain.records;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public record RecordClass(int a, int b) {
    public static int x = 12;

    public static void display(){

    }

    public void foo(){
        System.out.println("RecordClass.foo");
    }

    public static record InnerRecord(int x){

        public static void foo(){

        }

    }

    public class InnerClass{

         public static record InnerRecord(){

         }

    }

    public static class NestedClass{

    }
}
