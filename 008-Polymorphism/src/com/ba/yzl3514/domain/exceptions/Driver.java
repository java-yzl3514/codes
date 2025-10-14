package com.ba.yzl3514.domain.exceptions;

import java.io.File;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {

    public static void main(String[] args) {


        /*
        IOReader reader = new FileReader();
        try{
            reader.read();
        }catch (Exception e){
        }
         */

        FileReader reader = new FileReader();
        reader.read();
    }
}
