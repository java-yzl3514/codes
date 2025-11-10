package ba.yzl3514.main;

import java.util.logging.Logger;

/**
 * catch blockları hiyerarşik olarak özelden-genele yazılmalı
 * Aksi durum derleme zamanı hatasıdır.
 *
 * @author Onder Sahin
 *
 */
public class SuperSubCatch {

    private static final Logger log = Logger.getLogger(SuperSubCatch.class.getName());

    public static void main(String[] args) {

        try{
            int a = 0;
            int b = 100 / a;
        }catch (ArithmeticException e){
            log.severe(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            log.severe(e.getMessage());
        }catch (Exception e){
            log.severe(e.getMessage());
        }

    }
}
