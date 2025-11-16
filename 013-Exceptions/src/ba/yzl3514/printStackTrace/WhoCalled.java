package ba.yzl3514.printStackTrace;

import ba.yzl3514.java_7_multicatch.exceptions.ExceptionC;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class WhoCalled {


    public static void foo(){
        try{
            throw new Exception();
        }catch (Exception e){
            for(StackTraceElement element : e.getStackTrace()){
                System.out.printf("ClassLoader: %s%nClass Name: %s%nFile Name: %s%nMethod Name: %s%nLine Number: %d%n---------%n",
                        element.getClassLoaderName(),element.getClassName(), element.getFileName(), element.getMethodName(),element.getLineNumber());
            }
        }
    }

    public static void bar(){
        foo();
    }

    public static void tar(){
        bar();
    }


    public static void main(String[] args) {

        foo();
        System.out.println("===========================");
        bar();
        System.out.println("===========================");
        tar();
    }
}
