package com.ba.yzl3514.interfaces;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public abstract interface Flyable {

    void fly();

    default void foo(){
        System.out.println("DEFAULT Foo Behaviour");
    }

    // yorum satırını kaldırınız ve koda olan etkisini gözlemleyiniz
    // void bar();
}
