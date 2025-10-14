/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class ObjectFieldsInitialization {

    public static int value;
    public int objectValue;
    public String name;


    public ObjectFieldsInitialization(){
        this("UNKNOWN");
    }

    public ObjectFieldsInitialization(int objectValue){
        this("UNKNOWN");
        this.objectValue = objectValue;
        System.out.println("ObjectFieldsInitialization.ctor");
    }

    public ObjectFieldsInitialization(String name){
        this.name = name;
    }

}
