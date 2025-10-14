/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class InitializerErrorApp {

    public static void main(String[] args) {


        try{
            new InitializerError();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println("Continue");

        new InitializerError();
    }
}
