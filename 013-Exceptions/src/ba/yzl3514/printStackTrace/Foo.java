package ba.yzl3514.printStackTrace;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Foo {

    private Bar bar;

    public Foo(Bar bar){
        this.bar = bar;
    }

    public void foo(){
        bar.bar();
    }
}
