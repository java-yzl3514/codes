package com.ba.yzl3514.interfaces;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public interface Messenger {

    default void send(String message){
        System.out.println("Sending message via Messenger: " + message);
    }
}
