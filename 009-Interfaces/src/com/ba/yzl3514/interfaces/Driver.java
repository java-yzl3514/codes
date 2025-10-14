package com.ba.yzl3514.interfaces;

import com.ba.yzl3514.interfaces.domain.InternetConnection;
import com.ba.yzl3514.interfaces.domain.Whatsapp;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Driver {


    public static void main(String[] args) {

        Whatsapp whatsapp = new Whatsapp();
        whatsapp.run();

        Whatsapp.staticMethod();

        //InternetConnection.checkStability();
        Connection.checkStability();

    }
}
