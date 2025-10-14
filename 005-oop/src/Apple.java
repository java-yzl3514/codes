/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Apple {

    public int color;

    public Apple(){

    }

    public void peel(int a) {
        System.out.println("Apple.peel(" + a + ")");
        this.color = a;
    }

    public void foo(Apple apple) {
        System.out.println("Apple.foo()");
        Apple apple1 = new Apple();
        apple1.color = 46;
    }

    public static void noNeedAppleReference(){
        // this.color = 45; // Static context içerisinden this referansına erişilemez !!
        Apple apple = new Apple();
        apple.color = 90;
    }
}

