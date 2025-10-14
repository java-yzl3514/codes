package ba.yzl3514.domain.local;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Outer {

    public void foo() {

        String message = "Ave Java !";
        // ....
        message = "Other value";

        class LocalClass{

            public void foo(){
               // message = "new value";
            }

            private void bar(){}

        }

        LocalClass localClass = new LocalClass();
        localClass.foo();
        localClass.bar();
    }

    {


        class LocalClass{

        }


    }
}
