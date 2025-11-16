package ba.yzl3514.resource_management;

import java.io.File;
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
public class FileRead {

    public static void main(String[] args) {


        // OLD MANUAL WAY
        FileInputStream inputStream = null;

        try{
            inputStream = new FileInputStream(new File("some.file"));
        }catch (IOException e){
            System.out.println("An exception is occurred.");
        }finally {
            if(inputStream != null) {
                try {
                    inputStream.close(); // NullPointException
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    /**
     *  JAVA 7 WAY
     *  PROJECT COIN
     */
    public static void twr(){
        try (FileInputStream inputStream = new FileInputStream(new File("some.file"))){

        }catch (IOException e){
            System.out.println("An exception is occurred.");
        }
    }
}
