package ba.yzl3514.exception_specification;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DatabaseDriver {


    public void connect() throws FileNotFoundException, ConnectException, IOException {
        //...
        boolean fileNotFound = false;
        if (fileNotFound) {
            throw new FileNotFoundException();
        }

        boolean isConnectionEstablished = false;
        if(isConnectionEstablished){
            throw new ConnectException();
        }

        throw  new RuntimeException();
        //System.out.println("continue");
    }

}
