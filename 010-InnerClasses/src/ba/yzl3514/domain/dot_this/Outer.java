package ba.yzl3514.domain.dot_this;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class Outer {


    private void foo() {
        System.out.println("Outer.foo()");
    }

    public class Inner{

        public void foo() {
            System.out.println("Inner.foo()");
            Outer.this.foo();

        }

//        public class Outer{
//              COMPILE-TIME ERROR : Duplicate class
//        }

        public class InnerInner{

            public void foo(){
                Outer.this.foo();
            }

        }
    }
}
