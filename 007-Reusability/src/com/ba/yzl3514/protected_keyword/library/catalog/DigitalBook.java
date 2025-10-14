package com.ba.yzl3514.protected_keyword.library.catalog;

import com.ba.yzl3514.protected_keyword.library.core.Book;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class DigitalBook extends Book {

    public void verifyContent(){
        title = "A Digital Adventure";
        openBook();


        DigitalBook digitalBook = new DigitalBook();
        digitalBook.title = "Another Digital Adventure";
    }

    public void compareWith(Book otherBook){
         // ---- INVALID ACCESS -----
        // JLS KURALI : "Referansın türü S (DigitalBook) veya onun bir alt türü olmalı"
        //otherBook.openBook();
        // System.out.println(otherBook.title);
        //---------------------------------------

        if(otherBook instanceof DigitalBook){
            DigitalBook digitalBook = (DigitalBook) otherBook;
            System.out.println(digitalBook.title);
        }

    }

}
