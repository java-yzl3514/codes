package ba.yzl3514.resource_management;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class TryWithResources {

    public static void main(String[] args) {
           //  resource specification header
        try(Socket socket = new Socket("server.com", 80)){

        }
        catch (IOException e){

        }
        //socket
    }

    public static void multiResources(){
        try(Socket socket = new Socket("server.com", 80); FileInputStream stream = new FileInputStream("Some.file")){

        }
        catch (IOException e){

        }
    }
}
