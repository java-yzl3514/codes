package com.ba.yzl3514.ctor_chaining;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Car extends Vehicle{

    public Car(){
        super(); // Otomatik ekleme kuralıyla eklenebilir.Açıkça yazıldı.
        System.out.println("2. Car ctor is called");
    }

}
