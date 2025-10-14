package ba.yzl3514.domain.records;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {

        System.out.println(RecordClass.x);
        RecordClass recordClass = new RecordClass(34, 67);

        System.out.println(recordClass.a());

        // recordClass.a(37); // Dikkat edilirse "set" metodunun olmadığı görülecektir.

        recordClass.foo();

        RecordClass recordClass1 = new RecordClass(34, 67);

        if(recordClass.equals(recordClass1)){
            System.out.println("Yes they are same !");
        }

        System.out.println(recordClass);

    }
}
