package ba.yzl3514.domain.inherit_from_inner;

/**
 *
 * Qualified super invocation
 *
 * @author Onder Sahin
 *
 */
public class InheritInner extends Outer.Inner{

    public InheritInner(Outer outer){
            outer.super();
    }

//    public InheritInner(){
//        new Outer().super();
//    }
}
