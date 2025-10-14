package com.ba.yzl3514.interfaces;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public interface Mailer {

    default void send(String message){
        System.out.println("Sending message via Mailer: " + message);
    }

}
