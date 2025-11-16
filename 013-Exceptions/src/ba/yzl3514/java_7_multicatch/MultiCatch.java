package ba.yzl3514.java_7_multicatch;

import ba.yzl3514.java_7_multicatch.exceptions.ExceptionA;
import ba.yzl3514.java_7_multicatch.exceptions.ExceptionB;
import ba.yzl3514.java_7_multicatch.exceptions.ExceptionC;
import ba.yzl3514.java_7_multicatch.exceptions.ExceptionD;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class MultiCatch {


    public void foo() throws ExceptionA, ExceptionB, ExceptionC, ExceptionD {

    }

    public void consume1() {

    }

    public void consume2() {

    }

    public void process() {

//        try {
//            foo();
//        } catch (ExceptionA e) {
//            throw new RuntimeException(e);
//        } catch (ExceptionB e) {
//            throw new RuntimeException(e);
//        } catch (ExceptionC e) {
//            throw new RuntimeException(e);
//        } catch (ExceptionD e) {
//            throw new RuntimeException(e);
//        }

    // Base sınıf yazılamaz
        try {
            foo();
        } catch (ExceptionA | ExceptionC e) {
            consume1();
        } catch (ExceptionB | ExceptionD e) {
            consume2();
        }

    }


}
