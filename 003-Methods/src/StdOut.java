/**
 * @author Onder Sahin
 */
public class StdOut {

    public static void print(String message){ // print(String)
        System.out.println(message);
    }


    public static void print(int data){ // print(int)
        System.out.println("Data: " + data);
    }


    public static void print(String message, int repeatCount){ // print(String,int)
        while(repeatCount-- > 0) {
            System.out.println(message);
        }

        // TODO : for döngüsüyle de yazınız
    }

    public static void print(int repeatCount, String message){ // print(int,String)
        // OVERLOADING !!!!
        /*
                TEKRAR YAPIYOR MUSUNUZ ?
         */
    }

}
