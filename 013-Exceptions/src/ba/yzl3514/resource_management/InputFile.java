package ba.yzl3514.resource_management;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.SortedMap;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class InputFile {

    private BufferedReader reader;

    public InputFile(String fileName) {
        try {
            reader = new BufferedReader(new FileReader(fileName));
            //.....
        } catch (FileNotFoundException e) {
            System.out.println("Could not open the file");
        } catch (Exception e) {

            /// ....

            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } finally {
            // ?????? DO NOT CLOSE HERE !!!
         /*
            try {
                reader.close();
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }

          */
        }

    }


    public void close() {
        try {
            reader.close();
        }catch (IOException ex){
            throw new RuntimeException(ex);
        }

    }


}
