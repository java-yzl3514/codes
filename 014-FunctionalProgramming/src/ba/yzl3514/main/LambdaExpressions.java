package ba.yzl3514.main;

import ba.yzl3514.domain.lambda.args.MultiArg;
import ba.yzl3514.domain.lambda.args.NoArg;
import ba.yzl3514.domain.lambda.args.SingleArg;

/**
 *
 *
 *
 * @author Onder Sahin
 *
 */
public class LambdaExpressions {

    static SingleArg singleArg = a -> a + " No Paranthesis!";
    static SingleArg singleArg1 = (a) -> a + " with  Paranthesis!";
    static NoArg noArg = () -> "No arg";
    static MultiArg multiArg = (s,i) -> s + i;
    static NoArg moreLines = () -> {
        System.out.println("more lines!");
        return "from moreLines()";
    };

    public static void main(String[] args) {
        System.out.println(singleArg.foo("Super!"));
        System.out.println(singleArg1.foo("Hello"));
        System.out.println(noArg.detail());
        System.out.println(multiArg.twoArg("Three", 3));
        System.out.println(moreLines.detail());
    }
}
