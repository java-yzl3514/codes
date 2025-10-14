package com.ba.yzl3514.interfaces;

import com.ba.yzl3514.interfaces.domain.SmartClient;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DriverMessageSender {

    public static void main(String[] args) {

        SmartClient smartClient = new SmartClient();

        Mailer mailer = smartClient;
        mailer.send("Hello");

    }
}
