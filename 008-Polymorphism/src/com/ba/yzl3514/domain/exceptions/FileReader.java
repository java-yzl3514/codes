package com.ba.yzl3514.domain.exceptions;

import java.io.EOFException;
import java.io.IOException;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class FileReader extends IOReader{

    /*
    // Override değil çünkü IOReader üzerinde belirtilen metodun
    // bildirdiği exception türünden daha genel bir exception türü
    public void read() throws Exception{
        System.out.println("FileReader.read...");
    }
     */


    /*
    // Override çünkü IOReader üzerinde belirtilen metodun
    // bildirdiği exception türünden daha dar kapsamlı bir istisna türü
    public void read() throws EOFException{
        System.out.println("FileReader.read...");
    }
     */

    /*
     Override çünkü üst sınıfın bildirim yaptığı gibi
     istisna fırlatma bildirimi yapmayabilir yani istisna fırlatmayabilir
     */
    @Override
    public void read() {
        System.out.println("FileReader.read...");
    }

    public void foo(){

    }
}
